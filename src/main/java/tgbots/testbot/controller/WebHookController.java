package tgbots.testbot.controller;


import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {

    private final MyBot myBot;

    public WebHookController(MyBot myBot) {
        this.myBot = myBot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> apiMethod(@RequestBody Update update) {
        return myBot.onWebhookUpdateReceived(update);
    }




}
