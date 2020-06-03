package Commands;

import static XmlManagers.XMLSaver.saveCollection;

/**
 * Команда "Сохрани мою речь"
 */
public class Save {
        static String description ="save : сохранить коллекцию в файл";

        /**
         * Метод для сохранения коллекции в файл
         * @param c коллекция
         */
        public static void save (Routes.Collection c) {
                saveCollection(c, c.getPath());
        }
}
