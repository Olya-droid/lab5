package XmlManagers;

import Exceptions.FileNotFoundException;
import Routes.Collection;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для чтения xml
 */
public class XmlReader {
    /**
     * Метод для получения коллекции из файла xml
     * @param path путь
     * @return Коллекция  (Collection)
     */
    public static Collection getCollection(String path) {

        try{
            File input = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            bufferedReader.close();
            return (Collection) unmarshaller.unmarshal(bufferedReader);
        }catch (JAXBException e){
            System.out.println("Некорректный файл");
            return null;
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("ошибка закрытия потока чтения");
            return null;
        }

    }

}
