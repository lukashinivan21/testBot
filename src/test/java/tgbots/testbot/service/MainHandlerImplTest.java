package tgbots.testbot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import tgbots.testbot.constants.Keyboards;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static tgbots.testbot.constants.Files.*;
import static tgbots.testbot.constants.StringConstants.*;

@ExtendWith(MockitoExtension.class)
class MainHandlerImplTest {

    private final HandlerInputUpdate handlerInputUpdateMock = mock(HandlerInputUpdate.class);

    private Handler out;
    private final Update update = new Update();
    private final Message message = new Message();
    private final CallbackQuery callbackQuery = new CallbackQuery();
    private final SendMessage sendMessage1 = new SendMessage("125", GREETING_STEP1);
    private final SendMessage sendMessage2 = new SendMessage("125", MESS_FOR_BUTTON8);


    @BeforeEach
    public void initOut() {
        out = new MainHandlerImpl(handlerInputUpdateMock);
    }

    @BeforeEach
    void setUp() {

        Chat chat1 = new Chat(125L, "Create");
        User user1 = new User(125L, "Tom", false);

        message.setChat(chat1);
        message.setFrom(user1);
        callbackQuery.setMessage(message);
        callbackQuery.setFrom(user1);

        sendMessage1.setReplyMarkup(Keyboards.keyboard2());

        Mockito.when(handlerInputUpdateMock.handleMessage(message)).thenReturn(sendMessage1);
        Mockito.when(handlerInputUpdateMock.handleCallback(callbackQuery)).thenReturn(sendMessage2);
    }

    @Test
    void sendingMessageWhenUpdateHasMessageWithText() {
        message.setText(TEXT_BUTTON1);
        update.setMessage(message);
        SendMessage sendMessage = out.sendingMessage(update);
        String result = sendMessage.getText();
        ReplyKeyboard keyboard = sendMessage.getReplyMarkup();
        Assertions.assertEquals(result, GREETING_STEP1);
        Assertions.assertEquals(keyboard, Keyboards.keyboard2());
    }

    @Test
    void sendingMessageWhenUpdateHasCallbackQuery() {
        callbackQuery.setData(CALLBACK_BUTTON8);
        update.setCallbackQuery(callbackQuery);

        SendMessage sendMessage = out.sendingMessage(update);
        String result = sendMessage.getText();
        Assertions.assertEquals(result, MESS_FOR_BUTTON8);
    }

    @Test
    void sendingDocumentButton5() {
        callbackQuery.setData(CALLBACK_BUTTON5);
        update.setCallbackQuery(callbackQuery);

        SendDocument document = out.sendingDocument(update);
        String result = document.getCaption();
        InputFile doc = document.getDocument();
        String name = doc.getMediaName();
        Assertions.assertEquals(result, MESS_FOR_BUTTON5);
        assertEquals(NAME1, name);
    }


    @Test
    void sendingDocumentButton7() {
        callbackQuery.setData(CALLBACK_BUTTON7);
        update.setCallbackQuery(callbackQuery);

        SendDocument document = out.sendingDocument(update);
        String result = document.getCaption();
        InputFile doc = document.getDocument();
        String name = doc.getMediaName();
        Assertions.assertEquals(result, MESS_FOR_BUTTON7);
        Assertions.assertEquals(name, NAME3);
    }

    @Test
    void sendingDocumentButton12() {
       callbackQuery.setData(CALLBACK_BUTTON12);
       update.setCallbackQuery(callbackQuery);

       SendDocument document = out.sendingDocument(update);
       String result = document.getCaption();
       InputFile doc = document.getDocument();
       String name = doc.getMediaName();
       Assertions.assertEquals(result, MESS_FOR_BUTTON12);
       Assertions.assertEquals(name, NAME7);
    }

    @Test
    void sendingDocumentButton16() {
        callbackQuery.setData(CALLBACK_BUTTON16);
        update.setCallbackQuery(callbackQuery);

        SendDocument document = out.sendingDocument(update);
        String result = document.getCaption();
        InputFile doc = document.getDocument();
        String name = doc.getMediaName();
        Assertions.assertEquals(result, MESS_FOR_BUTTON16);
        Assertions.assertEquals(name, NAME11);
    }
}