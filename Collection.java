import java.util.*;

public class Collection {

    public static ArrayList <Route> routes = new ArrayList<>();


    public static void show (){
        for (Route n: routes){
            System.out.println("  " + n.toString());
        }
    }
}
