package Commands;
import java.util.ArrayList;
public class Clear {
    static String description ="clear : очистить коллекцию";
    public static void clear(Routes.Collection c) {
        c.Routes.clear();
    }
}
