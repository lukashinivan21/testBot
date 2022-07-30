package tgbots.testbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import tgbots.testbot.botstate.BotState;
import tgbots.testbot.constants.Keyboards;
import tgbots.testbot.models.Candidate;
import tgbots.testbot.repository.CandidateRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static tgbots.testbot.constants.StringConstants.*;

@Service
public class HandlerInputUpdateImpl implements HandlerInputUpdate {

    private final CandidateRepository candidateRepository;

    private BotState currentBotState = null;
    private final Map<String, BotState> botStatesOfUsers = new HashMap<>();
    private final Pattern pattern = Pattern.compile("([+0-9]{10,})(\\s*)([\\W+]+)");

    public HandlerInputUpdateImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public SendMessage handleMessage(Message message) {

        SendMessage sendMessage = new SendMessage();
        String chatId = message.getChatId().toString();
        Long idChat = message.getChatId();
        String userName = message.getFrom().getUserName();
        sendMessage.setChatId(chatId);
        BotState state = botStatesOfUsers.get(chatId);

        if (message.hasText()) {

            String inputMessage = message.getText();
            Matcher matcher = pattern.matcher(inputMessage);

            if (state == BotState.GET_INFO && matcher.matches()) {
                String phoneNumber = matcher.group(1);
                String name = matcher.group(3);
                Candidate candidate = new Candidate();
                candidate.setId(idChat);
                candidate.setName(name);
                candidate.setUserName(userName);
                candidate.setPhoneNumber(phoneNumber);
                candidateRepository.save(candidate);
                sendMessage.setText(SUCCESS_ADD);
                currentBotState = BotState.DIALOG;
                botStatesOfUsers.put(chatId, currentBotState);
            } else if (state == BotState.GET_INFO && !matcher.matches()) {
                sendMessage.setText(CHECK_MESS);
            }

            if (START.equals(inputMessage) && state != null) {
                sendMessage.setText(NO_FIRST_VISIT);
                sendMessage.setReplyMarkup(Keyboards.keyboard1());
            }

            switch (inputMessage) {
                case START:
                    sendMessage.setText(MAIN_GREETING);
                    sendMessage.enableMarkdown(true);
                    sendMessage.setReplyMarkup(Keyboards.keyboard1());
                    currentBotState = BotState.DIALOG;
                    botStatesOfUsers.put(chatId, currentBotState);
                    break;
                case TEXT_BUTTON1:
                    sendMessage.setText(GREETING_STEP1);
                    sendMessage.setReplyMarkup(Keyboards.keyboard2());
                    currentBotState = BotState.DIALOG;
                    botStatesOfUsers.put(chatId, currentBotState);
                    break;
                case TEXT_BUTTON2:
                    sendMessage.setText(GREETING_STEP2);
                    sendMessage.setReplyMarkup(Keyboards.keyboard3());
                    currentBotState = BotState.DIALOG;
                    botStatesOfUsers.put(chatId, currentBotState);
                    break;
                case TEXT_BUTTON3:
                    sendMessage.setText(MESS_FOR_BUTTON3);
                    sendMessage.setReplyMarkup(Keyboards.keyboard4());
                    currentBotState = BotState.GET_REPORT;
                    botStatesOfUsers.put(chatId, currentBotState);
                    break;
                case TEXT_BUTTON4:
                    sendMessage.setText(MESS_FOR_BUTTON4);
                    break;
                default:
                    sendMessage.setText(MESS_DEFAULT);
                    sendMessage.setReplyMarkup(Keyboards.keyboard1());
                    currentBotState = BotState.DIALOG;
                    botStatesOfUsers.put(chatId, currentBotState);
                    break;
            }
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
                currentBotState = BotState.GET_INFO;
                botStatesOfUsers.put(chatId, currentBotState);
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
