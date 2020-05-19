package Commands;
import Routes.Collection;
import Routes.Route;

/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_distance {
        static String description ="max_by_distance: вывести любой объект из коллекции, значение поля distance которого является максимальным";

        /**
         *  Метод для вывода элемента коллекции Routes с максимальным значением поля distance
         * @param c коллекция
         */
        public static void  max_by_distance (Collection c){
        if (c.Routes.size() > 0) {
                Route maxRoutebyDist = c.Routes.get(0);
                for (Route r: c.Routes) {
                        if (r.getDistance()>maxRoutebyDist.getDistance() ) {
                                maxRoutebyDist = r;
                        }
                }
                System.out.println(maxRoutebyDist);
        } else
        System.out.println("Коллекция пуста как моё сердце");
}
}

