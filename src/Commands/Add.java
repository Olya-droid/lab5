package Commands;

import Readers.*;
import Routes.*;

import java.util.Objects;

/**
 * Команда "Добавить элемент"
 */

public class Add {
    static String description = "add {element} : добавить новый элемент в коллекцию";

    /**
     * Метод для добавления новых элементов в коллекцию
     * @param reader объект - считыватель
     * @param c коллекция
     * @throws NullPointerException
     */
    public static void add(ConsoleSourceReader reader, Collection c) throws NullPointerException {
        try {
            System.out.print("Давайте попробуем добавить элемент." + "\n" + "Как вы хотите, чтобы его звали?  ");
            Route route = new Route();
            route.setId(c.generateUniqueID());

            String name = reader.getLine();
            if (name == null | name.equals("")) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            route.setName(name);

            System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
            int coordinateX = Checker.intChecker(reader.getLine());
            if (coordinateX <= -836){
                System.out.println("Coordinate x должно быть больше -836");
                return;
            }

            System.out.print("float Y = ");
            float coordinateY = Checker.floatChecker(reader.getLine());
            if (coordinateY >= 840){
                System.out.println("Coordinate y должно быть меньше 840");
                return;
            }

            route.setCoordinates(new Coordinates(coordinateX, coordinateY));


            System.out.print("\n" + "Откуда? (from)" + "\n" + "long x = ");
            long locationFromX = Checker.longChecker(reader.getLine());

            System.out.print("double y = ");
            double locationFromY = Checker.doubleChecker(reader.getLine());

            System.out.print("Имя откуда:  ");
            String locationFromName = reader.getLine();
            if (locationFromName == null | locationFromName.equals("")) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }
            route.setFrom(new Location(locationFromX, locationFromY, locationFromName));

            System.out.print( "\n" +"Куда? (to)" + "\n" + "long x = ");
            long locationToX = Checker.longChecker(reader.getLine());

            System.out.print("double y = ");
            double locationToY = Checker.doubleChecker(reader.getLine());

            System.out.print("Имя куда:  ");
            String locationToName = reader.getLine();
            if (locationToName == null | locationToName.equals("")) {
                System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                return;
            }

            route.setTo(new Location(locationToX, locationToY, locationToName));


            System.out.print("\n" + "Давай посмотрим, что у нас там с Distance. (float)  ");
            float distance = Checker.floatChecker(reader.getLine());
            if (!(distance > 1)) {
                System.out.println("Значение Distance должно быть больше 1");
                return;
            }
            route.setDistance(distance);


            route.setCreationDate(java.time.LocalDate.now());


            c.Routes.add(route);
            System.out.println("Успех!");

        } catch (NullPointerException e) {
            return;
        }

    }
}
