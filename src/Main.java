import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Readers.FileSourceReader;
import Routes.Collection;
import XmlManagers.XmlReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import javax.xml.bind.JAXBException;

/**
 * Главный класс, в котором происходит вся магия
 */

public class Main {

    /**
     * Главный метод, в котором происходит вся магия
     */

    public static void main(String[] args) throws IOException {

        final long start = System.nanoTime();
        Signal.handle(new Signal("INT"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("Программа завершает работу");
                //if (Console.Console.HandlerB("Введите Bool: ", Command.boolCheck)) {
                System.out.format("\nПрограмма работала %f сек.\n", (System.nanoTime() - start) / 1e9f);//ctrl-c
                System.exit(0);
                //}
            }
        });

        boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        Collection c = new Collection();
        String path;
        String[] s;

        System.out.println("\n \n" + "Введите расположение файла с коллекцией: ");
        path = bufferReader.getLine()+"";
        while (!new File(path).exists()){
            System.out.println("такого файла там нет, введите другой путь");
            path = bufferReader.getLine()+"";
        }
        try {
            c = XmlReader.getCollection(path);
            c.setPath(path);
        }catch (FileNotFoundException e){
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
