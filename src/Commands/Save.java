package Commands;

import java.io.FileNotFoundException;
import static XmlManagers.Saver.saveCollection;

/**
 * Команда "Сохрани мою речь"
 */
public class Save {
        static String description ="save : сохранить коллекцию в файл";

        /**
         * Метод для сохранения коллекции в файл
         * @param c коллекция
         * @throws FileNotFoundException
         */
        public static void save (Routes.Collection c) throws FileNotFoundException{
                saveCollection(c, c.getPath());
        }
}
