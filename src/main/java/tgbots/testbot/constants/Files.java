package tgbots.testbot.constants;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;


public class Files {

    private static final File INFO = new File("/!INFO/Информация о приюте.pdf");
    public static final InputFile FULL_INFO = new InputFile(INFO);


    private static final File ADDRESS = new File("/!INFO/Адрес приюта и расписание работы.pdf");
    public static final InputFile FULL_ADDRESS = new InputFile(ADDRESS);

    private static final File REC = new File("/!INFO/Техника безопасности на территории приюта.pdf");
    public static final InputFile FULL_REC = new InputFile(REC);

    private static final File CONTACT = new File("/!INFO/Правила знакомства.pdf");
    public static final InputFile FULL_CONTACT = new InputFile(CONTACT);

    private static final File DOC = new File("/!INFO/Список документов.pdf");
    public static final InputFile FULL_DOC = new InputFile(DOC);

    private static final File TRANS = new File("/!INFO/Рекомендации по транспортировке животного.pdf");
    public static final InputFile FULL_TRANS = new InputFile(TRANS);

    private static final File HOME_PUPPY = new File("/!INFO/Рекомендации по обустройству дома для щенка.pdf");
    public static final InputFile FULL_PUPPY = new InputFile(HOME_PUPPY);

    private static final File HOME_DOG = new File("/!INFO/Рекомендации по обустройству дома для взрослой собаки.pdf");
    public static final InputFile FULL_DOG = new InputFile(HOME_DOG);

    private static final File HOME = new File("/!INFO/Рекомендации по обустройству дома для собаки c ограниченными возможностями.pdf");
    public static final InputFile FULL_HOME = new InputFile(HOME);

    private static final File FIRST_CONTACT = new File("/!INFO/Рекомендации кинолога по первичному общению.pdf");
    public static final InputFile FULL_FIRST = new InputFile(FIRST_CONTACT);

    private static final File EXPERTS = new File("/!INFO/Список кинологов.pdf");
    public static final InputFile LIST_EXP = new InputFile(EXPERTS);

    private static final File REJ = new File("/!INFO/Причины отказа.pdf");
    public static final InputFile FULL_REJ = new InputFile(REJ);

    private static final File FORM = new File("/!INFO/Образец формы отчета.pdf");
    public static final InputFile FULL_FORM = new InputFile(FORM);

    private static final File INST = new File("/!INFO/Рекомендации по заполнению и отправке отчета.pdf");
    public static final InputFile FULL_INST = new InputFile(INST);


}
