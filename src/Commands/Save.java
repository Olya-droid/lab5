package Commands;

import java.io.FileNotFoundException;

import static XmlManagers.Saver.saveCollection;

public class Save {

        static String description ="save : сохранить коллекцию в файл";

        public static void save (Routes.Collection c) throws FileNotFoundException {

                saveCollection(c, "./src/data/input.xml");

        }

}
