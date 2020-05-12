package Commands;

import java.util.Collections;

public class sort {
        static String description ="sort: отсортиовать коллекцию в ествественном порядке.";
        public sort (Routes.Collection c) {
             Collections.sort(c);
        }

}
