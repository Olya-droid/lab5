package Commands;

import Exceptions.FileFormatException;
import Exceptions.WrongFileNameException;

import static XmlManagers.Saver.saveCollection;

public class Save {

    static String description ="save : сохранить коллекцию в файл";

    public static void save (Routes.Collection c) throws WrongFileNameException, FileFormatException {

        saveCollection(c, "input.xml");

    }

}
