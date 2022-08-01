package tgbots.testbot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface HandlerInputUpdate {

    SendMessage handleMessage(Message message);

    SendMessage handleCallback(CallbackQuery callbackQuery);

}
