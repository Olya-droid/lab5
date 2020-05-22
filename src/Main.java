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
        Signal.handle(new Signal("INT"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("\n" + "Контрлцешное завершение программы");
                System.exit(0);
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
        try {
            while (work) {
                System.out.print("\n \n" + "Введите, что вам надо: ");
                s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
                work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
            }
        } catch (NullPointerException e){
            System.out.println(  " Контрлдешное завершение программы" );
        }

        System.out.println("\n" + "Наконец-то эта программа завершается...");
        bufferReader.close();
    }

}
