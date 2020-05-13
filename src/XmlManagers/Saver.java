package XmlManagers;

import Exceptions.FileFormatException;
import Exceptions.WrongFileNameException;
import Routes.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Saver {

    public static void saveCollection(Collection c, String path) throws FileFormatException, WrongFileNameException {

        try{
            File newCollection = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            PrintWriter printWriter = new PrintWriter(newCollection);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(c, printWriter);
        }catch (JAXBException e){
            throw new FileFormatException();
        }catch (FileNotFoundException e) {
            throw new WrongFileNameException();
        }
    }

}
