package XmlManagers;

import java.io.FileNotFoundException;
import Routes.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.PrintWriter;

/**
 * Класс - сохранщик
 */
public class XMLSaver {

    /**
     * Метод для сохранения коллекции в файл
     * @param c коллекция
     * @param path путь до файла
     */
    public static void saveCollection(Collection c, String path) {

        try{
            File newCollection = new File(path);
            if (!newCollection.exists()) throw new FileNotFoundException();
            if (!newCollection.canWrite()) {
                System.out.println("Запись в файл невозможна. Сделайте что-нибудь, если хотите сохранить именно в этот файл.");
                return;
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            PrintWriter printWriter = new PrintWriter(newCollection);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(c, printWriter);
        } catch (JAXBException e){
            System.out.println("Некорректный файл");
        }catch (FileNotFoundException e){
            System.out.println("Кажется, такого файла нам нет");
        }catch (NullPointerException e){
            System.out.println("Ошибка чтения файла");
        }
    }
}
