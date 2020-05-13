package XmlManagers;

import Exceptions.FileFormatException;
import Exceptions.WrongFileNameException;

import Routes.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;

public class Reader {

    public static Collection getCollection(String path) throws FileFormatException, WrongFileNameException {

        try{
            File input = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            return (Collection) unmarshaller.unmarshal(bufferedReader);
        }catch (JAXBException e){
            throw new FileFormatException();
        }catch (FileNotFoundException e){
            throw new WrongFileNameException();
        }

    }

}
