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

import static tgbots.testbot.constants.Files.*;
import static tgbots.testbot.constants.StringConstants.*;

@Service
public class MainHandlerImpl implements Handler {

    private final HandlerInputUpdate handlerInputUpdate;

    private final Logger logger = LoggerFactory.getLogger(MainHandlerImpl.class);

    public MainHandlerImpl(HandlerInputUpdate handlerInputUpdate) {
        this.handlerInputUpdate = handlerInputUpdate;
    }

    @Override
    public BotApiMethod<?> sendingMessage(Update update) {
        SendMessage result = null;

        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            logger.info("New callbackQuery from User: {}, userId: {}, withData: {}", callbackQuery.getFrom().getUserName(),
                    callbackQuery.getFrom().getId(), callbackQuery.getData());
            result = handlerInputUpdate.handleCallback(callbackQuery);
        }

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            logger.info("New message from User: {}, userId: {}, chatId: {}, with text: {}", message.getFrom().getUserName(), message.getFrom().getId(),
                    message.getChatId(), message.getText());
            result = handlerInputUpdate.handleMessage(message);
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
            case CALLBACK_BUTTON5:
                sendDocument.setDocument(FULL_INFO);
                sendDocument.setCaption(MESS_FOR_BUTTON5);
                break;
            case CALLBACK_BUTTON6:
                sendDocument.setDocument(FULL_ADDRESS);
                sendDocument.setCaption(MESS_FOR_BUTTON6);
                break;
            case CALLBACK_BUTTON7:
                sendDocument.setDocument(FULL_REC);
                sendDocument.setCaption(MESS_FOR_BUTTON7);
                break;
            case CALLBACK_BUTTON9:
                sendDocument.setDocument(FULL_CONTACT);
                sendDocument.setCaption(MESS_FOR_BUTTON9);
                break;
            case CALLBACK_BUTTON10:
                sendDocument.setDocument(FULL_DOC);
                sendDocument.setCaption(MESS_FOR_BUTTON10);
                break;
            case CALLBACK_BUTTON11:
                sendDocument.setDocument(FULL_TRANS);
                sendDocument.setCaption(MESS_FOR_BUTTON11);
                break;
            case CALLBACK_BUTTON12:
                sendDocument.setDocument(FULL_PUPPY);
                sendDocument.setCaption(MESS_FOR_BUTTON12);
                break;
            case CALLBACK_BUTTON13:
                sendDocument.setDocument(FULL_DOG);
                sendDocument.setCaption(MESS_FOR_BUTTON13);
                break;
            case CALLBACK_BUTTON14:
                sendDocument.setDocument(FULL_HOME);
                sendDocument.setCaption(MESS_FOR_BUTTON14);
                break;
            case CALLBACK_BUTTON15:
                sendDocument.setDocument(FULL_FIRST);
                sendDocument.setCaption(MESS_FOR_BUTTON15);
                break;
            case CALLBACK_BUTTON16:
                sendDocument.setDocument(LIST_EXP);
                sendDocument.setCaption(MESS_FOR_BUTTON16);
                break;
            case CALLBACK_BUTTON17:
                sendDocument.setDocument(FULL_REJ);
                sendDocument.setCaption(MESS_FOR_BUTTON17);
                break;
            case CALLBACK_BUTTON18:
                sendDocument.setDocument(FULL_FORM);
                sendDocument.setCaption(MESS_FOR_BUTTON18);
                break;
            case CALLBACK_BUTTON19:
                sendDocument.setDocument(FULL_INST);
                sendDocument.setCaption(MESS_FOR_BUTTON19);
                break;
        }
        return sendDocument;
    }

}
