import java.io.*;
import Readers.*;
import Routes.Collection;

import XmlManagers.XmlReader;

/**
 * Главный класс, в котором происходит вся магия
 */

public class Main {

    /**
     * Главный метод, в котором происходит вся магия
     */
    public static void main(String[] args) throws IOException {

        boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
        Collection c = XmlReader.getCollection("resources/input.xml");
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        String [] s;
        while (work) {
            System.out.print("\n \n"+"Введите, что вам там надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
        }
        System.out.println("Наконец-то эта программа завершается...");

    }

}
