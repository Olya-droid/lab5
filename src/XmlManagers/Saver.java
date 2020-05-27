package XmlManagers;

import Exceptions.FileNotFoundException;
import Routes.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.PrintWriter;

/**
 * Класс - сохранщик
 */
public class Saver {

    /**
     * Метод для сохранения коллекции в файл
     * @param c коллекция
     * @param path путь до файла
     * @throws java.io.FileNotFoundException
     */
    public static void saveCollection(Collection c, String path) throws java.io.FileNotFoundException {

        try{
            File newCollection = new File(path);
            if (!newCollection.exists()) throw new FileNotFoundException();
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            PrintWriter printWriter = new PrintWriter(newCollection);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(c, printWriter);
        } catch (JAXBException e){
            System.out.println("Некорректный файл");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
