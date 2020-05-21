import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Routes.Collection;
import XmlManagers.XmlReader;

import java.io.File;
import java.io.IOException;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * Главный класс, в котором происходит вся магия
 */

public class Main {

    /**
     * Главный метод, в котором происходит вся магия
     */

    public static void main(String[] args) throws IOException {

        Signal.handle(new Signal("INT"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("Наконец-то эта программа завершается...");//ctrl-c
                System.exit(0);
            }
        });

        boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        Collection c;
        String path;
        String[] s;

        System.out.println("\n \n" + "Введите расположение файла с коллекцией: ");
        path = bufferReader.getLine()+"";
        while (!new File(path).exists()){
            System.out.println("такого файла там нет, введите другой путь");
            path = bufferReader.getLine()+"";
        }
        c = XmlReader.getCollection(path);
        c.setPath(path);

        while (work) {
            System.out.print("\n \n" + "Введите, что вам надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
        }

        System.out.println("Наконец-то эта программа завершается...");
        bufferReader.close();
    }

    //execute_script resources/test.txt
    //resources/input.xml
}
