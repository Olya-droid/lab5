import java.util.*;
import java.io.File;

public class Collection {

    public static ArrayList <Route> routes = new ArrayList<>();

    public static void show (){
        for (Route n: routes){
            System.out.println("  " + n.toString());
        }
    }


    public Route searchById(Integer id) {
        for (Route r : routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

}
