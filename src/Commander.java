import Commands.*;
import Exceptions.EndOfSourceException;
import Exceptions.FileFormatException;
import Exceptions.WrongFileNameException;
import Routes.Collection;
import Readers.*;

public class Commander {
    public  static boolean switcher(ConsoleSourceReader reader, Collection c, String s1, String s2) throws EndOfSourceException, WrongFileNameException, FileFormatException {
        switch (s1) {
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
                System.out.println("Неизвестная команда. Попробуйте написать что-нибудь как-нибудь иначе.");
        }
        return true;
    }
}
