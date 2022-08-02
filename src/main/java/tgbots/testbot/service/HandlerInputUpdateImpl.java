package tgbots.testbot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import tgbots.testbot.botstate.BotState;
import tgbots.testbot.constants.Keyboards;
import tgbots.testbot.models.Candidate;
import tgbots.testbot.models.CatOwner;
import tgbots.testbot.models.DogOwner;
import tgbots.testbot.repository.CandidateRepository;
import tgbots.testbot.repository.CatOwnerRepository;
import tgbots.testbot.repository.DogOwnerRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static tgbots.testbot.constants.StringConstants.*;

@Service
public class HandlerInputUpdateImpl implements HandlerInputUpdate {

    private final CandidateRepository candidateRepository;
    private final DogOwnerRepository dogOwnerRepository;
    private final CatOwnerRepository catOwnerRepository;

    private final Pattern pattern = Pattern.compile("([+0-9]{10,})(\\s*)([\\W+]+)");

    public HandlerInputUpdateImpl(CandidateRepository candidateRepository, DogOwnerRepository dogOwnerRepository, CatOwnerRepository catOwnerRepository) {
        this.candidateRepository = candidateRepository;
        this.dogOwnerRepository = dogOwnerRepository;
        this.catOwnerRepository = catOwnerRepository;
    }

    @Override
    public SendMessage handleMessage(Message message) {

        SendMessage sendMessage = new SendMessage();

        Long idChat = message.getChatId();
        String chatId = idChat.toString();

        String userName = message.getFrom().getUserName();

        sendMessage.setChatId(chatId);

        if (message.hasText()) {
            String inputMessage = message.getText();
            List<Long> chatIds = candidateRepository.findAll().stream().map(Candidate::getId).collect(Collectors.toList());

            if (chatIds.contains(idChat)) {
                Candidate candidate = candidateRepository.findCandidateById(idChat);
                if (candidate.getBotState().equals(BotState.GET_REPORT.toString()) && message.hasDocument()) {
                    String text = message.getText();
                    Document photo = message.getDocument();
                    if (text != null && photo != null) {
                        sendMessage.setText(REPORT_OK);
                    } else {
                        sendMessage.setText("Информация не была сохранена");
                    }
                } else if (candidate.getBotState().equals(BotState.GET_REPORT.toString())) {
                    sendMessage.setText(REPORT_NOT_FULL);
                }
            }

            if (inputMessage.equals(START) && chatIds.contains(idChat)) {
                Candidate candidateA = candidateRepository.findCandidateById(idChat);
                sendMessage.setText(NO_FIRST_VISIT);
                sendMessage.enableMarkdown(true);
                sendMessage.setReplyMarkup(Keyboards.keyboard1());
                candidateA.setBotState(BotState.DIALOG.toString());
                candidateRepository.save(candidateA);
            } else if (inputMessage.equals(START)) {
                sendMessage.setText(MAIN_GREETING);
                sendMessage.setReplyMarkup(Keyboards.chooseShelter());
            }

            if (chatIds.contains(idChat) && !inputMessage.equals(START)) {
                Candidate candidateB = candidateRepository.findCandidateById(idChat);
                if (candidateB.getBotState().equals(BotState.DIALOG.toString())) {
                    switch (inputMessage) {
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
                            candidateB.setBotState(BotState.GET_REPORT.toString());
                            candidateRepository.save(candidateB);
                            break;
                        case TEXT_BUTTON4:
                            sendMessage.setText(MESS_FOR_BUTTON4);
                            break;
                        case PHONE_NUMBER:
                            sendMessage.setText(candidateRepository.findCandidateById(idChat).getPhoneNumber());
                            break;
                        default:
                            sendMessage.setText(MESS_DEFAULT);
                            sendMessage.enableMarkdown(true);
                            sendMessage.setReplyMarkup(Keyboards.keyboard1());
                            break;
                    }
                }
            }


            if (chatIds.contains(idChat)) {

                Candidate candidateC = candidateRepository.findCandidateById(idChat);

                Matcher matcher = pattern.matcher(inputMessage);

                if (candidateC.getBotState().equals(BotState.GET_INFO.toString()) && matcher.matches()) {
                    sendMessage.setText(SUCCESS_ADD);
                    String phoneNumber = matcher.group(1);
                    String name = matcher.group(3);
                    candidateC.setName(name);
                    candidateC.setPhoneNumber(phoneNumber);
                    candidateC.setUserName(userName);
                    candidateC.setBotState(BotState.DIALOG.toString());
                    candidateRepository.save(candidateC);
                } else if (candidateC.getBotState().equals(BotState.GET_INFO.toString()) && !matcher.matches()) {
                    sendMessage.setText(CHECK_MESS);
                }
            }
        }
        return sendMessage;
    }


    @Override
    public SendMessage handleCallback(CallbackQuery callbackQuery) {

        Long idChat = callbackQuery.getMessage().getChatId();
        String chatId = idChat.toString();
        String data = callbackQuery.getData();

        List<Long> dogOwnersId = dogOwnerRepository.findAll().stream().map(DogOwner::getId).collect(Collectors.toList());
        List<Long> catOwnersId = catOwnerRepository.findAll().stream().map(CatOwner::getId).collect(Collectors.toList());

        DogOwner dogOwner = dogOwnerRepository.findDogOwnerById(idChat);
        CatOwner catOwner = catOwnerRepository.findCatOwnerById(idChat);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        switch (data) {
            case CALLBACK_DOG:
                sendMessage.setText(MESS_DOG);
                sendMessage.enableMarkdown(true);
                sendMessage.setReplyMarkup(Keyboards.keyboard1());
                DogOwner newDogOwner = new DogOwner();
                newDogOwner.setId(idChat);
                newDogOwner.setBotState(BotState.DIALOG.toString());
                dogOwnerRepository.save(newDogOwner);
                break;
            case CALLBACK_CAT:
                sendMessage.setText(MESS_CAT);
                sendMessage.enableMarkdown(true);
                sendMessage.setReplyMarkup(Keyboards.keyboard1());
                CatOwner newCatOwner = new CatOwner();
                newCatOwner.setId(idChat);
                newCatOwner.setBotState(BotState.DIALOG.toString());
                catOwnerRepository.save(newCatOwner);
                break;
//            case CALLBACK_BUTTON5:
//                sendMessage.setText(MESS_FOR_BUTTON5);
//                break;
//            case CALLBACK_BUTTON6:
//                sendMessage.setText(MESS_FOR_BUTTON6);
//                break;
//            case CALLBACK_BUTTON7:
//                sendMessage.setText(MESS_FOR_BUTTON7);
//                break;
            case CALLBACK_BUTTON8:
                sendMessage.setText(MESS_FOR_BUTTON8);
                if (dogOwnersId.contains(idChat)) {
                    dogOwner.setBotState(BotState.GET_INFO.toString());
                    dogOwnerRepository.save(dogOwner);
                } else if (catOwnersId.contains(idChat)) {
                    catOwner.setBotState(BotState.GET_INFO.toString());
                    catOwnerRepository.save(catOwner);
                }
                break;
//            case CALLBACK_BUTTON9:
//                sendMessage.setText(MESS_FOR_BUTTON9);
//                break;
//            case CALLBACK_BUTTON10:
//                sendMessage.setText(MESS_FOR_BUTTON10);
//                break;
//            case CALLBACK_BUTTON11:
//                sendMessage.setText(MESS_FOR_BUTTON11);
//                break;
//            case CALLBACK_BUTTON12:
//                sendMessage.setText(MESS_FOR_BUTTON12);
//                break;
//            case CALLBACK_BUTTON13:
//                sendMessage.setText(MESS_FOR_BUTTON13);
//                break;
//            case CALLBACK_BUTTON14:
//                sendMessage.setText(MESS_FOR_BUTTON14);
//                break;
//            case CALLBACK_BUTTON15:
//                sendMessage.setText(MESS_FOR_BUTTON15);
//                break;
//            case CALLBACK_BUTTON16:
//                sendMessage.setText(MESS_FOR_BUTTON16);
//                break;
//            case CALLBACK_BUTTON17:
//                sendMessage.setText(MESS_FOR_BUTTON17);
//                break;
//            case CALLBACK_BUTTON18:
//                sendMessage.setText(MESS_FOR_BUTTON18);
//                break;
//            case CALLBACK_BUTTON19:
//                sendMessage.setText(MESS_FOR_BUTTON19);
//                break;
//            case CALLBACK_BUTTON4:
//                sendMessage.setText(MESS_FOR_BUTTON4);
//                break;
//            default:
//                sendMessage.setText(MESS_DEFAULT);
//                break;
        }
        return sendMessage;
    }
}
