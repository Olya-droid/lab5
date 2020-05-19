package Commands;

import java.util.Collections;

/**
 * Команда "СОРТИРОВКА"
 */
public class Sort {
        static String description ="sort: отсортиовать коллекцию в ествественном порядке.";

    /**
     * Метод для сортировки коллекции в ествественном порядке (по возрастанию id)
     * @param c коллекция
     */
    public static void  sort (Routes.Collection c) {
           Collections.sort(c.Routes);
        }

}
