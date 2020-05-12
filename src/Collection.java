import java.util.*;
import java.io.File;

public class Collection {

    public static ArrayList <Route> Routes = new ArrayList<>();

    public static void show (){
        for (Route n: Routes){
            System.out.println("  " + n.toString());
        }
    }


    public Route searchById(Integer id) {
        for (Route r : Routes) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }

}
