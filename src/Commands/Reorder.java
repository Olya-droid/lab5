package Commands;
import java.util.Collections;

public class Reorder {

    static String description ="reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
public static void reorder (Routes.Collection c) {
    Collections.reverse(c.Routes);
 }
}
