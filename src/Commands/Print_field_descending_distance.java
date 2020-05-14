package Commands;

import Routes.Collection;
import Routes.Route;

import java.util.Arrays;

public class Print_field_descending_distance {
        static String description ="print_field_descending_distance: вывести значение поля distance в порядке убывания.";
public static void print_field_descending_distance (Collection c) {
        if (!c.Routes.isEmpty()) {
                float[] array = new float[c.Routes.size()];
                int i = 0;
                for (Route r : c.Routes) {
                        array[i] = r.getDistance();
                        i++;
                }

                Arrays.sort(array);
                for (i = c.Routes.size() - 1; i >= 0; i--) {
                        System.out.println(array[i]);
                }
        }else System.out.println("Коллекция пуста, в отличие от моего рабочего стола.");
}
}
