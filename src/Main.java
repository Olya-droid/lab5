import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Routes.Collection;
import XmlManagers.XmlReader;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.IOException;

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
        Collection c = null;
        String path;
        String[] s;

        System.out.println("\n \n Добро пожаловать!");

        while(c == null){
            System.out.println("Введите расположение файла с коллекцией или нажмите Enter, чтобы начать работу с дефолтной коллекцией: ");
            path = bufferReader.getLine() + "";
            if (path.equals("")){
                path = "resources/input.xml";
                System.out.println("Вы начали работу с коллекцией по умолчанию. Если хотите увидеть ее элементы, введите \"show\"");
            }
            c = XmlReader.getCollection(path);
            c.setPath(path);
        }
        while (work) {
            System.out.print("\n \n" + "Введите, что вам надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            if (s == null) continue;
            work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
        }
        System.out.println("\n" + "Наконец-то эта программа завершается...");
        bufferReader.close();
    }
}
