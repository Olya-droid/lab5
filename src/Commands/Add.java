package Commands;
import Exceptions.EndOfSourceException;
import Readers.*;
import Routes.*;

import java.util.Objects;


public class Add {
    static String description = "add {element} : добавить новый элемент в коллекцию";

    public static void add(ConsoleSourceReader reader, Collection c) throws EndOfSourceException, NullPointerException {
try {
    System.out.println("Давайте попробуем добавить элемент." + "\n" + "Как вы хотите, чтобы его звали?");
    Route route = new Route();
    route.setId(c.generateUniqueID());

    String name = reader.getLine();
    if (name == null | name.equals("")) {
        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
        return;
    }
    route.setName(name);

    System.out.println("\n" + "Координаты, пожалуйста." + "\n" + "X = ");
    int coordinateX = Checker.intChecker(reader.getLine());
    //                    if (coordinateX == null) return;
    System.out.println("Y = ");
    float coordinateY = Checker.floatChecker(reader.getLine());
    //                  if (coordinateY == null) return;
    route.setCoordinates(new Coordinates(coordinateX, coordinateY));

    System.out.println("\n" + "Откуда? (from)" + "\n" + "x = ");
    long locationFromX = Checker.longChecker(reader.getLine());
    //               if (Objects.equals(locationFromX, null)) return;
    System.out.println("\n" +"y = ");
    double locationFromY = Checker.doubleChecker(reader.getLine());
    System.out.println("\n" +"Имя откуда:");
    String locationFromName = reader.getLine();
    if (locationFromName == null | locationFromName.equals("")) {
        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
        return;
    }
    route.setFrom(new Location(locationFromX, locationFromY, locationFromName));
    System.out.println("\n" + "Куда? (to)" + "\n" + "x = ");
    long locationToX = Checker.longChecker(reader.getLine());
    System.out.println("y = ");
    double locationToY = Checker.doubleChecker(reader.getLine());
    System.out.println("\n" +"Имя куда:");
    String locationToName = reader.getLine();
    if (locationToName == null | locationToName.equals("")) {
        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
        return;
    }
    route.setTo(new Location(locationToX, locationToY, locationToName));
    System.out.println("\n" + "Давай посмотрим, что у нас там с Distance");
    float distance = Checker.floatChecker(reader.getLine());
    route.setDistance(distance);
    route.setCreationDate(java.time.LocalDate.now());
    c.Routes.add(route);
    System.out.println("Успех!");

} catch (NullPointerException e) {
    return;
}

        }
    }
