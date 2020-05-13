package Commands;

import Routes.Route;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
        static String description ="sort: отсортиовать коллекцию в ествественном порядке.";
        public static void  sort (Routes.Collection c) {
            Collections.sort(c.Routes);
        }

}
