import Generators.DateGenerator;

import java.util.ArrayList;
import java.time.LocalDate;
import java.io.File;

public class Collection {

    private static ArrayList<Route> Routes;

    private LocalDate initializationDate;

    public Collection(){
        ArrayList<Route> Routes = new ArrayList<>();
        initializationDate = DateGenerator.generateCurrentDate();
    }

    public static void show(){
        for (Route n: Routes){
            System.out.println("  " + n.toString());
        }
    }


    public Route searchById(Long id) {
        for (Route r : Routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

}
