package tgbots.testbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import tgbots.testbot.constants.Keyboards;

import static tgbots.testbot.constants.StringConstants.*;

@Service
public class HandlerInputUpdateImpl implements HandlerInputUpdate {

    @Override
    public SendMessage handleMessage(Message message) {

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
                sendMessage.setReplyMarkup(Keyboards.keyboard4());
                break;
            case TEXT_BUTTON4:
                sendMessage.setText(MESS_FOR_BUTTON4);
                break;
            default:
                sendMessage.setText(MESS_DEFAULT);
                break;
        }
        return sendMessage;
    }

    @Override
    public SendMessage handleCallback(CallbackQuery callbackQuery) {

        String chatId = callbackQuery.getMessage().getChatId().toString();
        String data = callbackQuery.getData();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        switch (data) {
            case CALLBACK_BUTTON5:
                sendMessage.setText(MESS_FOR_BUTTON5);
                break;
            case CALLBACK_BUTTON6:
                sendMessage.setText(MESS_FOR_BUTTON6);
                break;
            case CALLBACK_BUTTON7:
                sendMessage.setText(MESS_FOR_BUTTON7);
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
            case CALLBACK_BUTTON18:
                sendMessage.setText(MESS_FOR_BUTTON18);
                break;
            case CALLBACK_BUTTON19:
                sendMessage.setText(MESS_FOR_BUTTON19);
                break;
            case CALLBACK_BUTTON4:
                sendMessage.setText(MESS_FOR_BUTTON4);
                break;
            default:
                sendMessage.setText(MESS_DEFAULT);
                break;
        }
        return sendMessage;
    }


}
