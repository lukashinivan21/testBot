package tgbots.testbot.service;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Handler {

    BotApiMethod<?> sendingMessage(Update update);

    SendDocument  sendingDocument(Update update);

}
