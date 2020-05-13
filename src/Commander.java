import Commands.*;
import Routes.Collection;

public class Commander {
    public static boolean switcher(Reader reader, Collection c, String s1, String s2) {
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
                Add.add(reader, c, s2);
                break;
            case ("update"):
                Update.update(reader, c, s2);
                break;
            case ("remove_by_id"):
                Remove_by_id.remove_by_id(reader, c, s2);
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
                Exit.exit();
            case ("history"):
                History.history();
                break;
            case ("max_by_distace"):
                Max_by_distance.max_by_distance(c);
                break;
            case ("print_field_descending_distance"):
                Print_field_descending_distance.print_field_descending_distance();
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
    }
}
