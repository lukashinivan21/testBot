package tgbots.testbot.constants;

import java.util.ArrayList;
import java.util.List;

public class StringConstants {

    public static final String START = "/start";

    public static final String MAIN_GREETING = "Привет, пользователь. Я помогу тебе подобрать самого веселого и замечательного щенка из нашего питомника." +
            " Выбери один из пунктов главного меню";
    public static final String MESS_DEFAULT = "Воспользуйтесь главным меню";

//    public static final String FIRST_MESSAGE = "Привет, пользователь. Меню ниже поможет тебе узнать необходимую информацию о приюте. Выберите один из пунктов...";

//    четыре строки ниже можно закомментировать
    public static final String CALLBACK_BUTTON1 = "Приют";

    public static final String CALLBACK_BUTTON2 = "Собака";

    public static final String CALLBACK_BUTTON3 = "Отчет";

    public static final String CALLBACK_BUTTON4 = "Волонтер";
    public static final String MESS_FOR_BUTTON4 = "Волонтер подключиться к чату в ближайшее время...";

    public static final String TEXT_BUTTON1 = "Узнать информацию о приюте";

    public static final String TEXT_BUTTON2 = "Как взять собаку из приюта";

    public static final String TEXT_BUTTON3 = "Прислать отчет о питомце";
    public static final String MESS_FOR_BUTTON3 = "В файле приведен образец формы отчета и инструкции по его отправке и заполнению. От себя напомню, что отчет должен содержать" +
            " фотографии и текстовое описание того, как питомец чувствует себя на новом месте.";

    public static final String TEXT_BUTTON4 = "Позвать волонтера";

    public static final String GREETING_STEP1 = "Привет, пользователь. В меню ниже ты можешь узнать информацию о приюте. Выбери один из пунктов...";

    public static final String TEXT_BUTTON5 = "Общая информация о приюте";
    public static final String CALLBACK_BUTTON5 = "Инфо";
    public static final String MESS_FOR_BUTTON5 = "Пользователь, в файле ты найдешь полную информацию о нашем приюте.";

    public static final String TEXT_BUTTON6 = "Расписание работы и адрес приюта";
    public static final String CALLBACK_BUTTON6 = "Адрес";
    public static final String MESS_FOR_BUTTON6 = "Пользователь, в файле ты найдешь информацию о графике работы приюта, адрес и номер телефона";

    public static final String TEXT_BUTTON7 = "Техника безопасности на территории приюта";
    public static final String CALLBACK_BUTTON7 = "Рекомендация";
    public static final String MESS_FOR_BUTTON7 = "Пользователь, в файле ты найдешь необходимые рекомендации о технике безопасности на территории приюта.";

    public static final String TEXT_BUTTON8 = "Могу записать ваши контактные данные для связи";
    public static final String CALLBACK_BUTTON8 = "Контакт";
    public static final String MESS_FOR_BUTTON8 = "В ответном сообщении введи свои контакты в виде: \"+7xxxxxxxxxx ИМЯ e-mail\", где x - цифра от 0 до 9, без кавычек." +
            " Номер телефона и ИМЯ обязательны для заполнения. ИМЯ может содержать фамилию и имя или же только имя";

    public static final String GREETING_STEP2 = "Привет, пользователь. Меню ниже поможет тебе получить ответы на наиболее популярные вопросы. Выбери один из пунктов...";


    public static final String TEXT_BUTTON9 = "Правила знакомства с собакой";
    public static final String CALLBACK_BUTTON9 = "Знакомство";
    public static final String MESS_FOR_BUTTON9 = "В файле находятся все необходимые рекомендации для успешного знакомства с собакой";

    public static final String TEXT_BUTTON10 = "Список необходимых документов";
    public static final String CALLBACK_BUTTON10 = "Список";
    public static final String MESS_FOR_BUTTON10 = "В файле находится перечень документов, необходимых для того, чтобы забрать собаку из приюта";

    public static final String TEXT_BUTTON11 = "Рекомендации по транспортировке животного";
    public static final String CALLBACK_BUTTON11 = "Транспорт";
    public static final String MESS_FOR_BUTTON11 = "В файле находятся рекомендации для безопасной транспортировки животного";

    public static final String TEXT_BUTTON12 = "Рекомендации по обустройству дома для щенка";
    public static final String CALLBACK_BUTTON12 = "Щенок";
    public static final String MESS_FOR_BUTTON12 = "В файле находятся рекомендации по обустройству дома для щенка";

    public static final String TEXT_BUTTON13 = "Рекомендации по обустройству дома взрослой собаки";
    public static final String CALLBACK_BUTTON13 = "Взрослая";
    public static final String MESS_FOR_BUTTON13 = "В файле находятся рекомендации по обустройству дома для взрослой собаки";

    public static final String TEXT_BUTTON14 = "Рекомендации по обустройству дома для собаки с ограниченными возможностями";
    public static final String CALLBACK_BUTTON14 = "Обустройство";
    public static final String MESS_FOR_BUTTON14 = "В файле находятся рекомендации по обустройству дома для собаки с ограниченными возможностями";

    public static final String TEXT_BUTTON15 = "Советы кинолога по первичному общению с собакой";
    public static final String CALLBACK_BUTTON15 = "Советы";
    public static final String MESS_FOR_BUTTON15 = "В файле находятся рекомендации кинологов для успешного первичного знакомства с собакой";

    public static final String TEXT_BUTTON16 = "Список проверенных кинологов для дальнейших консультаций";
    public static final String CALLBACK_BUTTON16 = "Кинологи";
    public static final String MESS_FOR_BUTTON16 = "В файле находится список кинологов, проверенных сотрудниками нашего питомника";

    public static final String TEXT_BUTTON17 = "Причины отказа в заборе собаки из приюта";
    public static final String CALLBACK_BUTTON17 = "Отказ";
    public static final String MESS_FOR_BUTTON17 = "В файле находятся основные причины отказа в заборе собаки из приюта";

    private static final String[] callBacks = {CALLBACK_BUTTON5, CALLBACK_BUTTON6, CALLBACK_BUTTON7, CALLBACK_BUTTON9, CALLBACK_BUTTON10, CALLBACK_BUTTON11, CALLBACK_BUTTON12,
    CALLBACK_BUTTON13, CALLBACK_BUTTON14, CALLBACK_BUTTON15, CALLBACK_BUTTON16, CALLBACK_BUTTON17};

    public static final List<String> LIST_CALLBACKS = new ArrayList<>(List.of(callBacks));

}
