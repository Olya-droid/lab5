package Commands;
import Routes.Collection;

public class show {
    static String description ="show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    public void show (Collection c){
    c.show();
    }

}
