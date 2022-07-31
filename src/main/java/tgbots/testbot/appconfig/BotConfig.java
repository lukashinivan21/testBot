package tgbots.testbot.appconfig;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import tgbots.testbot.controller.MyBot;
import tgbots.testbot.service.Handler;


@Getter
@Setter
@Configuration
public class BotConfig {

    @Value("${telegram.bot.webHookPath}")
    private String webHookPath;

    @Value("${telegram.bot.botUsername}")
    private String botUserName;

    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public MyBot myBot(Handler handler) {
        DefaultBotOptions options = new DefaultBotOptions();

        MyBot myBot = new MyBot(options, handler);

        myBot.setBotUsername(botUserName);
        myBot.setToken(token);
        myBot.setWebHookPath(webHookPath);

        return myBot;
    }
}
