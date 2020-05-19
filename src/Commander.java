import Commands.*;
import Routes.Collection;
import Readers.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс, соотносящий введённую команду с доступными командами
 */
public class Commander {
    /**
     * Распределение команд
     * @param reader объект - считыватель
     * @param c коллекция
     * @param s1 команда
     * @param s2 данные, читаемые в одной строке с командой
     * @return возвращает true, если не была введена команда exit
     * @throws IOException
     */
    public  static boolean switcher(ConsoleSourceReader reader, Collection c, String s1, String s2) throws IOException {
        boolean historyCheck = true;
        switch (s1.toLowerCase()) {
            case ("help"):
                Help.help();
                break;
            case ("info"):
                Info.info(c);
                break;
            case ("show"):
                Show.show(c);
                break;
            case ("add"):
                Add.add(reader, c);
                break;
            case ("update"):
                Update.update(reader, c, s2);
                break;
            case ("remove_by_id"):
                Remove_by_id.remove_by_id(c, s2);
                break;
            case ("clear"):
                Clear.clear(c);
                break;
            case ("save"):
                Save.save(c);
                break;
            case ("execute_script"):
                return Execute_script.execute_script(c, s2);
            case ("exit"):
                return Exit.exit();
            case ("history"):
                History.history();
                break;
            case ("max_by_distance"):
                Max_by_distance.max_by_distance(c);
                break;
            case ("print_field_descending_distance"):
                Print_field_descending_distance.print_field_descending_distance(c);
                break;
            case ("reorder"):
                Reorder.reorder(c);
                break;
            case ("sort"):
                Sort.sort(c);
                break;
            case ("average_of_distance"):
                Average_of_distance.average_of_distance(c);
                break;


            default:
                historyCheck = false;
                System.out.println("Неизвестная команда. Попробуйте написать что-нибудь как-нибудь иначе.");
        }
        if(historyCheck)History.addInArray(s1);
        return true;
    }
}
