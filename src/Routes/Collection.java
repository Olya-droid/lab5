package Routes;

import Generators.DateGenerator;
import Generators.IDGenerator;

import java.util.ArrayList;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Collection {

    @XmlElement
    public static ArrayList<Route> Routes;

    private LocalDate initializationDate;

    public Collection(){
        this.Routes = new ArrayList<>();
        this.initializationDate = DateGenerator.generateCurrentDate();
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public static void show(){
        for (Route n: Routes){
            System.out.println("  " + n.toString());
        }
    }


    public Route searchById(long id) {
        for (Route r : Routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

    public long generateUniqueID() {
        long id;
        do {
            id = IDGenerator.generateNewID();
        } while (this.searchById(id) != null);
        return id;
    }

}
