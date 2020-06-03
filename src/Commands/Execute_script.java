package Commands;

import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Readers.FileSourceReader;

import java.io.File;
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
            ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
            while (s2 == null | s2.equals("")) {
                System.out.println("кажется, вы забыли ввести расположение файла. Где он лежит?");
                s2 = consoleSourceReader.getLine();
            }
            System.out.println("спасибо, но в следующий раз введите его в той же строке, что и команду" + "\n");
        }

         if (!getFileExtension(new File(s2)).equals("txt") && !getFileExtension(new File(s2)).equals("")){
            ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
            System.out.println("Файлы с расширением отличным от \"txt\" могуты быть прочитаны некорректно. Вы уверены, что хотите продолжить? ");
            boolean answerIsIncorrect = true;
            while (answerIsIncorrect){
                System.out.print("Введите \"yes\", если хотите продолжить работу с введенным выше файлом, \"no\", если хотите вернуться в меню ввода команд: ");
                String answer = consoleSourceReader.getLine();
                answer = answer.trim().toLowerCase();
                switch(answer) {
                    case ("yes"):
                        answerIsIncorrect = false;
                        break;
                    case ("no"):
                        return true;
                    default:
                        System.out.print("Ответ введен некорректно. ");
                }
            }
        }
        
        if (theSameExist(s2)){
            System.out.println("\n"+"-ать с рекурсией не надо игр-" +"\n");
            System.out.println("Рекурсивное чтение файла было завершено во избежание разрыва пространственно-временного континуума.");
        } else {
            usedFiles.add(s2);
            FileSourceReader fileSourceReader = new FileSourceReader(s2);
            String[] s;
            String line;
            line = fileSourceReader.getLine();
           s = CommandArgumentSplitter.comArgSplitter(line);
            while (fileWork && s != null) {
                fileWork = Commander.switcher(fileSourceReader, c, s[0], s[1]);
                line = fileSourceReader.getLine();
                s = CommandArgumentSplitter.comArgSplitter(line);
            }
            fileSourceReader.close();
            usedFiles.clear();
            System.out.println("Завершение скрипта");
        }
        return fileWork;

    }

    /**
     * Поиск передаваемого файла среди уже запущенных
     * @param s2 путь файла
     * @return true - если найден
     */
    private static boolean theSameExist (String s2){
        for (String s: usedFiles) if (s.equals(s2)) return true;
        return false;
    }
    
      /**
     * Определение расширение файла file
     * @param file файл
     * @return раширение файла file
     */
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }  

}
