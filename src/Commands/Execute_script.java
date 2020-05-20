package Commands;

import Exceptions.FileNotFoundException;
import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Readers.FileSourceReader;

import java.io.IOException;

/**
 * Команда "СКРИПТ"
 */

public class Execute_script {

    static String description = "execute_script file_name : считать и исполнить скрипт из указанного файла.В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";

    /**
     * Метод для выполнения скрипта
     *
     * @param c  коллекция
     * @param s2 имя файла
     * @return fileWork 
     */

    public static boolean execute_script(Routes.Collection c, String s2) {

        boolean fileWork = true;

        if (s2 == null | s2.equals("")) {
            System.out.println("кажется, вы забыли ввести расположение файла. Где он лежит?");
            ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
            s2 = consoleSourceReader.getLine();
            System.out.println("спасибо, но в следующий раз введите его в той же строке, что и команду" + "\n");
        }

        try {
            FileSourceReader fileSourceReader = new FileSourceReader(s2);
            String[] s;
            s = CommandArgumentSplitter.comArgSplitter(fileSourceReader.getLine());
            while (fileWork && s != null) {
                fileWork = Commander.switcher(fileSourceReader, c, s[0], s[1]);
                s = CommandArgumentSplitter.comArgSplitter(fileSourceReader.getLine());
            }
            fileSourceReader.close();
            System.out.println("файл успешно дочитался");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("неправильный формат ввода расположения файла");
        } catch (Exception e) {
            System.out.println("непредвиденный конец файла");
        }

        return fileWork;
    }

}
