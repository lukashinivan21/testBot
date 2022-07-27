package tgbots.testbot.constants;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

public class Files {

    private static final File INFO = new File("/myUniversity/avatars/Student{id=1, name='Ivan', age=30}.JPG");
    public static final InputFile FULL_INFO = new InputFile(INFO);

    private static final File ADDRESS = new File("/myUniversity/avatars/Student{id=1, name='Ivan', age=30}.JPG");
    public static final InputFile FULL_ADDRESS = new InputFile(ADDRESS);

    private static final File REC = new File("/МОЯ ПАПКА ДЛЯ РАБОТЫ/!SkyPro/Файлы/Рекомендация.txt");
    public static final InputFile FULL_REC = new InputFile(REC);

    private static final File CONTACT = new File("/МОЯ ПАПКА ДЛЯ РАБОТЫ/!SkyPro/Файлы/Знакомство.txt");
    public static final InputFile FULL_CONTACT = new InputFile(CONTACT);


//    /МОЯ ПАПКА ДЛЯ РАБОТЫ/!SkyPro/Файлы/Рекомендация/txt
}
