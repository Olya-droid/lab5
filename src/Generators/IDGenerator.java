package Generators;

import java.util.ArrayList;
import Routes.*;

public class IDGenerator {

    public static long generateNewID(ArrayList<Route> Routes){
        long id;
        do {
            id = (long) (1 + Math.random() * (Long.MAX_VALUE - 1));
        } while (Collection.searchById(id) != null);
        return id;
    }

}
