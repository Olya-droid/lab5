import java.io.*;

import Exceptions.EndOfSourceException;
import Exceptions.NoCommandException;
import Readers.*;
import Routes.Collection;

public class Main {
    public static void main(String[] args) throws IOException, EndOfSourceException, NoCommandException {
        boolean work = true;
        Collection c = new Collection();
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        String [] s;
        while (work) {
            System.out.println("\n \n"+"Введите, что вам там надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            work = Commander.switcher(bufferReader, c, s[0], s[1]);
        }
        System.out.println("наконец-то эта программа завершается");
    }
}
