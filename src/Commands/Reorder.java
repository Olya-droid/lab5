package Commands;
import java.util.Collections;

/**
 * Команда "ПЕРЕВЁРТЫШ"
 */
public class Reorder {

    static String description ="reorder: отсортировать коллекцию в порядке, обратном нынешнему.";

    /**
     * Метод для разворота коллекции
     * @param c коллекция
     */
    public static void reorder (Routes.Collection c) {
    Collections.reverse(c.Routes);
 }
}
