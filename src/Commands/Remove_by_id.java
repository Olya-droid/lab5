package Commands;
import Readers.*;
import Routes.Collection;

public class Remove_by_id {

        static String description ="remove_by_id id : удалить элемент из коллекции по его id";
public static void remove_by_id( Routes.Collection c, String s2){
       long removeId = Checker.longChecker(s2);

       c.Routes.remove(c.Routes.indexOf(c.searchById(removeId)));
}

}
