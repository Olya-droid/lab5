import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Routes.Collection;
import XmlManagers.XmlReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Главный класс, в котором происходит вся магия
 */

public class Main {

    /**
     * Главный метод, в котором происходит вся магия
     */
    
    public static void main(String[] args) throws IOException {

        boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        Collection c = new Collection();
        String path;
        String[] s;

        System.out.println("Введите расположение файла с коллекцией: ");
        path = bufferReader.getLine()+"";

        try {
            //if (path.equals("")) {
            // path = "resources/input.xml";
            //c.setPath(path);
            //}
            c.setPath(path);
            c = XmlReader.getCollection(c.getPath());
        }catch (FileNotFoundException e){
            //path =
            System.out.println("Ты чево наделал................");
            work = false;
        }

        while (work) {
            System.out.print("\n \n" + "Введите, что вам надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
        }

        System.out.println("Наконец-то эта программа завершается...");

    }

}
