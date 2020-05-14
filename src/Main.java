import java.io.*;
import Readers.*;
import Routes.Collection;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        boolean work = true;
        Collection c = XmlManagers.Reader.getCollection("./src/data/input.xml");
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        String [] s;
        while (work) {
            System.out.print("\n \n"+"Введите, что вам там надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            work = Commander.switcher(bufferReader, c, s[0], s[1]);
        }
        System.out.println("Наконец-то эта программа завершается...");

    }

}
