package tgbots.testbot.constants;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;


public class Files {

    private static final String FOLDER = "/!INFO/";

    public static final String NAME1 = "Информация о приюте.pdf";
    private static final File INFO = new File(FOLDER + NAME1);
    public static final InputFile FULL_INFO = new InputFile(INFO);


    public static final String NAME2 = "Адрес приюта и расписание работы.pdf";
    private static final File ADDRESS = new File(FOLDER + NAME2);
    public static final InputFile FULL_ADDRESS = new InputFile(ADDRESS);

    public static final String NAME3 = "Техника безопасности на территории приюта.pdf";
    private static final File REC = new File(FOLDER + NAME3);
    public static final InputFile FULL_REC = new InputFile(REC);

    public static final String NAME4 = "Правила знакомства.pdf";
    private static final File CONTACT = new File(FOLDER + NAME4);
    public static final InputFile FULL_CONTACT = new InputFile(CONTACT);

    public static final String NAME5 = "Список документов.pdf";
    private static final File DOC = new File(FOLDER + NAME5);
    public static final InputFile FULL_DOC = new InputFile(DOC);

    public static final String NAME6 = "Рекомендации по транспортировке животного.pdf";
    private static final File TRANS = new File(FOLDER + NAME6);
    public static final InputFile FULL_TRANS = new InputFile(TRANS);

    public static final String NAME7 = "Рекомендации по обустройству дома для детеныша.pdf";
    private static final File HOME_PUPPY = new File(FOLDER + NAME7);
    public static final InputFile FULL_PUPPY = new InputFile(HOME_PUPPY);

    public static final String NAME8 = "Рекомендации по обустройству дома для взрослого животного.pdf";
    private static final File HOME_DOG = new File(FOLDER + NAME8);
    public static final InputFile FULL_DOG = new InputFile(HOME_DOG);

    public static final String NAME9 = "Рекомендации по обустройству дома для животного c ограниченными возможностями.pdf";
    private static final File HOME = new File(FOLDER + NAME9);
    public static final InputFile FULL_HOME = new InputFile(HOME);

    public static final String NAME10 = "Рекомендации кинолога по первичному общению.pdf";
    private static final File FIRST_CONTACT = new File(FOLDER + NAME10);
    public static final InputFile FULL_FIRST = new InputFile(FIRST_CONTACT);

    public static final String NAME11 = "Список кинологов.pdf";
    private static final File EXPERTS = new File(FOLDER + NAME11);
    public static final InputFile LIST_EXP = new InputFile(EXPERTS);

    public static final String NAME12 = "Причины отказа.pdf";
    private static final File REJ = new File(FOLDER + NAME12);
    public static final InputFile FULL_REJ = new InputFile(REJ);

    public static final String NAME13 = "Образец формы отчета.pdf";
    private static final File FORM = new File(FOLDER + NAME13);
    public static final InputFile FULL_FORM = new InputFile(FORM);

    public static final String NAME14 = "Рекомендации по заполнению и отправке отчета.pdf";
    private static final File INST = new File(FOLDER + NAME14);
    public static final InputFile FULL_INST = new InputFile(INST);


}
