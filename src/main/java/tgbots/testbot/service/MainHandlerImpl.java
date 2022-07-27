package tgbots.testbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import tgbots.testbot.constants.Keyboards;

import static tgbots.testbot.constants.Files.*;
import static tgbots.testbot.constants.StringConstants.*;

@Service
public class MainHandlerImpl implements Handler {

    private final Logger logger = LoggerFactory.getLogger(MainHandlerImpl.class);

    @Override
    public BotApiMethod<?> sendingMessage(Update update) {
        SendMessage result = null;

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
//            String chatId = callbackQuery.getMessage().getChatId().toString();
            logger.info("New callbackQuery from User: {}, userId: {}, withData: {}", callbackQuery.getFrom().getUserName(),
                    callbackQuery.getFrom().getId(), callbackQuery.getData());
            BotApiMethod<?> answer;
            answer = handleCallbackQuery(callbackQuery);
            return answer;
        }

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            logger.info("New message from User: {}, userId: {}, chatId: {}, with text: {}", message.getFrom().getUserName(), message.getFrom().getId(),
                    message.getChatId(), message.getText());
            result = handleInputMessage(message);
        }
        return result;
    }

    @Override
    public SendDocument sendingDocument(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        String data = callbackQuery.getData();
        String chatId = callbackQuery.getMessage().getChatId().toString();
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        switch (data) {
            case CALLBACK_BUTTON5: sendDocument.setDocument(FULL_INFO);
            break;
            case CALLBACK_BUTTON6: sendDocument.setDocument(FULL_ADDRESS);
            break;
            case CALLBACK_BUTTON7: sendDocument.setDocument(FULL_REC);
            break;
            case CALLBACK_BUTTON9: sendDocument.setDocument(FULL_CONTACT);
            break;
        }
        return sendDocument;
    }

    private SendMessage handleInputMessage(Message message) {
        String inputMessage = message.getText();
        String chatId = message.getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

//        добавить еще одно условие в if
//        if (START.equals(inputMessage)) {
//            sendMessage.setText(FIRST_MESSAGE);
//            sendMessage.setReplyMarkup(Keyboards.keyboard1());
//        }

        switch (inputMessage) {
            case START:
                sendMessage.setText(MAIN_GREETING);
                sendMessage.enableMarkdown(true);
                sendMessage.setReplyMarkup(Keyboards.keyboard1());
                break;
            case TEXT_BUTTON1:
                sendMessage.setText(GREETING_STEP1);
                sendMessage.setReplyMarkup(Keyboards.keyboard2());
                break;
            case TEXT_BUTTON2:
                sendMessage.setText(GREETING_STEP2);
                sendMessage.setReplyMarkup(Keyboards.keyboard3());
                break;
            case TEXT_BUTTON3:
                sendMessage.setText(MESS_FOR_BUTTON3);
            case TEXT_BUTTON4:
                sendMessage.setText(MESS_FOR_BUTTON4);
                break;
            default:
                sendMessage.setText(MESS_DEFAULT);
        }
        return sendMessage;
    }

    private BotApiMethod<?> handleCallbackQuery(CallbackQuery callbackQuery) {

        String chatId = callbackQuery.getMessage().getChatId().toString();
        String data = callbackQuery.getData();
        BotApiMethod<?> result = null;
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        switch (data) {
            case CALLBACK_BUTTON5:
                sendMessage.setText(MESS_FOR_BUTTON5);
                result = sendMessage;
                break;
            case CALLBACK_BUTTON6:
                sendMessage.setText(MESS_FOR_BUTTON6);
                result = sendMessage;
                break;
            case CALLBACK_BUTTON7:
                sendMessage.setText(MESS_FOR_BUTTON7);
                result = sendMessage;
                break;
            case CALLBACK_BUTTON8:
                sendMessage.setText(MESS_FOR_BUTTON8);
                break;
            case CALLBACK_BUTTON9:
                sendMessage.setText(MESS_FOR_BUTTON9);
                break;
            case CALLBACK_BUTTON10:
                sendMessage.setText(MESS_FOR_BUTTON10);
                break;
            case CALLBACK_BUTTON11:
                sendMessage.setText(MESS_FOR_BUTTON11);
                break;
            case CALLBACK_BUTTON12:
                sendMessage.setText(MESS_FOR_BUTTON12);
                break;
            case CALLBACK_BUTTON13:
                sendMessage.setText(MESS_FOR_BUTTON13);
                break;
            case CALLBACK_BUTTON14:
                sendMessage.setText(MESS_FOR_BUTTON14);
                break;
            case CALLBACK_BUTTON15:
                sendMessage.setText(MESS_FOR_BUTTON15);
                break;
            case CALLBACK_BUTTON16:
                sendMessage.setText(MESS_FOR_BUTTON16);
                break;
            case CALLBACK_BUTTON17:
                sendMessage.setText(MESS_FOR_BUTTON17);
                break;
            case CALLBACK_BUTTON4:
                sendMessage.setText(MESS_FOR_BUTTON4);
                break;
            default: sendMessage.setText(MESS_DEFAULT);

        }
        return result;
    }










}
