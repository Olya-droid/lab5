package Commands;
import Routes.Collection;

import java.util.Collections;

public class reorder {

        static String description ="reorder: отсортировать коллекцию в порядке, обратном нынешнему.";
public reorder (Collection c) {
    Collections.reverse(c);
}
    }
