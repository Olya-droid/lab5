package Commands;
import Readers.*;
import Routes.Route;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id {

        static String description ="remove_by_id id : удалить элемент из коллекции по его id";

    /**
     * метод удаления элемента коллекции по его id
     * @param c коллекция
     * @param s2 id
     */
    public static void remove_by_id( Routes.Collection c, String s2){
    if (s2==null | s2.equals("")) {
        System.out.println("кажется вы забыли ввести айди");
        return;
    }

       long removeId = Checker.longChecker(s2);
    Route r = c.searchById(removeId);
    if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
        return;
    }
       c.Routes.remove(c.Routes.indexOf(r));
}
}
