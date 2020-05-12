package Routes;

import Generators.DateGenerator;
import java.util.ArrayList;
import java.time.LocalDate;

public class Collection {

    private static ArrayList<Route> Routes;

    private LocalDate initializationDate;

    public Collection(){
        ArrayList<Route> Routes = new ArrayList<>();
        initializationDate = DateGenerator.generateCurrentDate();
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
