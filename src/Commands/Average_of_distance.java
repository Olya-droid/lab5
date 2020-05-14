package Commands;

public class Average_of_distance {
    static String description ="average_of_distance : вывести среднее значение поля distance для всех элементов коллекции.";
    public static void average_of_distance(Routes.Collection c) {
        if (c.Routes.size() > 0) {
            Float sum = 0f;
            int countOfNull = 0;
            for (Routes.Route r : c.Routes) {
                if (r.getDistance() != null)
                    sum += r.getDistance();
                else
                    countOfNull++;
            }
            if (c.Routes.size() - countOfNull > 0)
                System.out.println("Среднее значение distance: " + sum / (c.Routes.size() - countOfNull));

        } else
        System.out.println("Коллекция пуста как банка кофе, купленая в начале выполнения этой работы");
    }
}

