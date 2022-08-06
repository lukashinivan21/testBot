package tgbots.testbot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import tgbots.testbot.botstate.BotState;
import tgbots.testbot.constants.Keyboards;
import tgbots.testbot.repository.CatOwnerRepository;
import tgbots.testbot.repository.DogOwnerRepository;


import static org.mockito.Mockito.mock;
import static tgbots.testbot.constants.Constants.*;
import static tgbots.testbot.constants.StringConstants.*;

@ExtendWith(MockitoExtension.class)
class HandlerInputUpdateImplTest {

    private final DogOwnerRepository dogOwnerRepositoryMock = mock(DogOwnerRepository.class);
    private final CatOwnerRepository catOwnerRepositoryMock = mock(CatOwnerRepository.class);


    private HandlerInputUpdate out;

    private final Message message1 = new Message();
    private final Message message2 = new Message();
    private final Message message3 = new Message();
    private final Message message4 = new Message();

    @BeforeEach
    public void initOut() {
        out = new HandlerInputUpdateImpl(dogOwnerRepositoryMock, catOwnerRepositoryMock);
    }

    @BeforeEach
    void setUp() {
        Chat chat1 = new Chat(125L, "Create");
        Chat chat2 = new Chat(12L, "Create");
        Chat chat3 = new Chat(19L, "Create");
        Chat chat4 = new Chat(21L, "Create");

        User user1 = new User(125L, "Tom", false);
        User user2 = new User(12L, "Ronald", false);
        User user3 = new User(19L, "Cris", false);
        User user4 = new User(21L, "Henry", false);

        message1.setChat(chat1);
        message1.setFrom(user1);
        message2.setChat(chat2);
        message2.setFrom(user2);
        message3.setChat(chat3);
        message3.setFrom(user3);
        message4.setChat(chat4);
        message4.setFrom(user4);

        Mockito.when(dogOwnerRepositoryMock.findAll()).thenReturn(DOG_OWNER_LIST);
        Mockito.when(catOwnerRepositoryMock.findAll()).thenReturn(CAT_OWNER_LIST);
        Mockito.when(dogOwnerRepositoryMock.findDogOwnerById(125L)).thenReturn(DOG_OWNER);
        Mockito.when(catOwnerRepositoryMock.findCatOwnerById(12L)).thenReturn(CAT_OWNER);

    }

    @Test
    void handleMessageStartWhenFirstVisit() {
        message3.setText(START);
        SendMessage sendMessage = out.handleMessage(message3);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, MAIN_GREETING);
        Assertions.assertEquals(keyboard, Keyboards.chooseShelter());
    }

    @Test
    void handleMessageStartWhenNoFirstVisitDog() {
        message1.setText(START);
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, NO_FIRST_VISIT);
    }

    @Test
    void handleMessageStartWhenNoFirstVisitCat() {
        message2.setText(START);
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, NO_FIRST_VISIT);
    }

    @Test
    void handleMessageForStage1() {
        message2.setText(TEXT_BUTTON1);
        CAT_OWNER.setBotState(BotState.DIALOG.toString());
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, GREETING_STEP1);
        Assertions.assertEquals(keyboard, Keyboards.keyboard2());
    }

    @Test
    void handleMessageForStage1WhenDogOwnerHasBotStateGET_INFO() {
        DOG_OWNER.setBotState(BotState.GET_INFO.toString());
        message1.setText(TEXT_BUTTON1);
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, CHECK_MESS);
    }

    @Test
    void handleMessageForStage2WhenDogOwnerHasBotStateGET_INFO() {
        DOG_OWNER.setBotState(BotState.GET_INFO.toString());
        message1.setText(TEXT_BUTTON2);
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, CHECK_MESS);
    }

    @Test
    void handleMessForStage2Dog() {
        DOG_OWNER.setBotState(BotState.DIALOG.toString());
        message1.setText(TEXT_BUTTON2);
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, GREETING_STEP2);
        Assertions.assertEquals(keyboard, Keyboards.keyboard3());
    }

    @Test
    void handleMessageForStage2Cat() {
        message2.setText(TEXT_BUTTON2);
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, GREETING_STEP2);
        Assertions.assertEquals(keyboard, Keyboards.keyboard3Cat());
    }


    @Test
    void handleMessageForStage3Dog() {
        DOG_OWNER.setBotState(BotState.DIALOG.toString());
        message1.setText(TEXT_BUTTON3);
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, MESS_FOR_BUTTON3);
        Assertions.assertEquals(keyboard, Keyboards.keyboard4());
    }

    @Test
    void handleMessageForStage3Cat() {
        message2.setText(TEXT_BUTTON3);
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, MESS_FOR_BUTTON3);
        Assertions.assertEquals(keyboard, Keyboards.keyboard4());
    }


    @Test
    void handleMessageConformToPattern() {
        DOG_OWNER.setBotState(BotState.GET_INFO.toString());
        message1.setText("+79683241210   Игорь Малов");
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        String botState = DOG_OWNER.getBotState();
        Assertions.assertEquals(result, SUCCESS_ADD);
        Assertions.assertEquals(botState, BotState.DIALOG.toString());
    }

    @Test
    void handleMessageNotConformToPattern() {
        DOG_OWNER.setBotState(BotState.GET_INFO.toString());
        message1.setText("Something wrong");
        SendMessage sendMessage = out.handleMessage(message1);
        String result = sendMessage.getText();
        String botState = DOG_OWNER.getBotState();
        Assertions.assertEquals(result, CHECK_MESS);
        Assertions.assertEquals(botState, BotState.GET_INFO.toString());
    }

    @Test
    void handleMessageConformToPatternForCatOwnerWhenBotStateNotEqualsGet_INFO() {
        message2.setText("+76253017896420  Катя Малышкина");
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_DEFAULT);
    }

    @Test
    void handleMessageConformToPatternForCatOwnerWhenBotStateEqualsGet_INFO() {
        CAT_OWNER.setBotState(BotState.GET_INFO.toString());
        message2.setText("+76253017896420  Катя Малышкина");
        SendMessage sendMessage = out.handleMessage(message2);
        String result = sendMessage.getText();
        String botState = CAT_OWNER.getBotState();
        Assertions.assertEquals(result, SUCCESS_ADD);
        Assertions.assertEquals(botState, BotState.DIALOG.toString());
    }

    @Test
    void handleCallbackDog() {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setMessage(message3);
        callbackQuery.setData(CALLBACK_DOG);
        SendMessage sendMessage = out.handleCallback(callbackQuery);
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_DOG);
        Assertions.assertEquals(keyboard, Keyboards.keyboard1());
    }

    @Test
    void handleCallbackCat() {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setMessage(message4);
        callbackQuery.setData(CALLBACK_CAT);
        SendMessage sendMessage = out.handleCallback(callbackQuery);
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_CAT);
        Assertions.assertEquals(keyboard, Keyboards.keyboard1());
    }

    @Test
    void handleCallbackContact() {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setMessage(message1);
        callbackQuery.setData(CALLBACK_BUTTON8);
        SendMessage sendMessage = out.handleCallback(callbackQuery);
        String result = sendMessage.getText();
        String botState = DOG_OWNER.getBotState();
        Assertions.assertEquals(result, MESS_FOR_BUTTON8);
        Assertions.assertEquals(botState, BotState.GET_INFO.toString());
    }

    @Test
    void whenUserChooseDogShelterAlready() {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setMessage(message1);
        callbackQuery.setData(CALLBACK_CAT);
        SendMessage sendMessage = out.handleCallback(callbackQuery);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_FOR_DOG_OWNER);
    }

    @Test
    void whenUserChooseCatShelterAlready() {
        CallbackQuery callbackQuery = new CallbackQuery();
        callbackQuery.setMessage(message2);
        callbackQuery.setData(CALLBACK_DOG);
        SendMessage sendMessage = out.handleCallback(callbackQuery);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_FOR_CAT_OWNER);
    }




}