package tgbots.testbot.controller;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import tgbots.testbot.service.Handler;

import static tgbots.testbot.constants.StringConstants.LIST_CALLBACKS;


public class MyBot extends TelegramWebhookBot {

    private final Handler handler;

    private String webHookPath;
    private String botUsername;
    private String token;


    public MyBot(DefaultBotOptions botOptions, Handler handler) {
        super(botOptions);
        this.handler = handler;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendDocument sendDocument = null;
        if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (LIST_CALLBACKS.contains(data)) {
                sendDocument = handler.sendingDocument(update);
            }
        }
        if (sendDocument != null) {
            try {
                execute(sendDocument);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return handler.sendingMessage(update);
    }


    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
