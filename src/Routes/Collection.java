package Routes;
import Generators.IDGenerator;
import Generators.DateGenerator;
import java.util.ArrayList;
import java.time.LocalDate;

public class Collection {

    public  ArrayList<Route> Routes;
    private LocalDate initializationDate;

    public Collection(){
       this.Routes = new ArrayList<>();
        this.initializationDate = DateGenerator.generateCurrentDate();
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
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
