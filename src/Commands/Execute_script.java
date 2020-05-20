package Commands;

import Exceptions.FileNotFoundException;
import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Readers.FileSourceReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Команда "СКРИПТ"
 */

public class Execute_script {

    static String description = "execute_script file_name : считать и исполнить скрипт из указанного файла.В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";

    protected static ArrayList<String> usedFiles = new ArrayList<>();

    static boolean fileWork = true;
    /**
     * Метод для выполнения скрипта
     *
     * @param c  коллекция
     * @param s2 имя файла
     * @return fileWork
     */

    public static boolean execute_script(Routes.Collection c, String s2) {
        if(s2 == null | s2.equals("")){
            while (s2 == null | s2.equals("")) {
                System.out.println("кажется, вы забыли ввести расположение файла. Где он лежит?");
                ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
                s2 = consoleSourceReader.getLine();
            }
            System.out.println("спасибо, но в следующий раз введите его в той же строке, что и команду" + "\n");
        }
        if (theSameExist(s2)){
            System.out.println("ать с рекурсией не надо игр");
            fileWork = false;
        }
        usedFiles.add(s2);
        try {
            FileSourceReader fileSourceReader = new FileSourceReader(s2);
            String[] s;
            s = CommandArgumentSplitter.comArgSplitter(fileSourceReader.getLine());
            while (fileWork && s != null) {
                fileWork = Commander.switcher(fileSourceReader, c, s[0], s[1]);
                s = CommandArgumentSplitter.comArgSplitter(fileSourceReader.getLine());
            }
            fileSourceReader.close();
            usedFiles.clear();
            System.out.println("файл успешно дочитался");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            usedFiles.clear();
        } catch (IOException e) {
            System.out.println("неправильный формат ввода расположения файла");
            usedFiles.clear();
        } catch (Exception e) {
            System.out.println("непредвиденный конец файла");
            usedFiles.clear();
        }

        return fileWork;
    }


    private static boolean theSameExist (String s2){
        for (String s: usedFiles) if (s.equals(s2)) return true;
        return false;
    }

}
