package Commands;
import Routes.Collection;
import Routes.Route;

public class Show {
    static String description ="show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    public static void show (Collection c) {
        if (c.Routes.size() == 0) {
            System.out.println("Коллекция пуста, милорд");
        } else {

            for (Route r : c.Routes) {
                System.out.println("  " + r.toString());
            }
        }
    }
}
