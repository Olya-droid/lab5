package XmlManagers;

import Exceptions.FileNotFoundException;
import Routes.Collection;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Класс для чтения xml
 */
public class XmlReader {
    /**
     * Метод для получения коллекции из файла xml
     * @param path путь
     * @return Коллекция  (Collection)
     * @throws java.io.FileNotFoundException
     */
    public static Collection getCollection(String path) {

        try{
            File input = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            return (Collection) unmarshaller.unmarshal(bufferedReader);
        }catch (JAXBException e){
            System.out.println("Некорректный файл");
            System.out.println("Коллекция создана с чистого листа");
            return new Collection();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Коллекция создана с чистого листа");
            return new Collection();
        }

    }

}
