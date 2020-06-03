package Commands;
import Readers.*;
import Routes.*;

/**
 * Команда "Добавить-ка ещё!"
 */

public class Add {
    static String description = "add {element} : добавить новый элемент в коллекцию";
    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean hasFrom = false; //показывает, было ли добавлено поле from
    static boolean hasTo = false; // показывает, было ли добавлено поле to
    static boolean hasDist = false; // показывает, было ли добавлено поле distance

    /**
     * Метод для добавления новых элементов в коллекцию
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     */
    public static void add(Reader reader, Collection c){
        Route route = new Route();
        route.setId(c.generateUniqueID());
        System.out.println("Давайте попробуем добавить элемент.");
        while (!Add.hasName) addName(reader, c, route);
        while (!Add.hasCoordinates) addCoordinates(reader, c, route);
        while (!Add.hasFrom) addFrom(reader, c, route);
        while (!Add.hasTo) addTo(reader, c, route);
        while (!Add.hasDist) addDist(reader, c, route);
        route.setCreationDate(java.time.LocalDate.now());
        c.Routes.add(route);
        System.out.println("Успех!");
        hasName = false;
        hasCoordinates = false;
        hasFrom = false;
        hasTo = false;
        hasDist = false;
    }

    /**
     * Метод добавления имени в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param route  объект
     */
    protected static void addName(Reader reader, Collection c, Route route){
        System.out.print( "\n" + "Как вы хотите, чтобы его звали?  ");
        String name = reader.getLine()+"";
        if (name.equals("") ) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        route.setName(name);
        Add.hasName = true;
    }

    /**
     * Метод добавления координат в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param route  объект
     */
    protected static void addCoordinates(Reader reader, Collection c, Route route) {
        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        int coordinateX;
        try {
            coordinateX = Checker.intChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate X должно быть типа int." + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateX <= -836) {
            System.out.println("Coordinate x должно быть больше -836");
            return;
        }

        System.out.print("float Y = ");
        float coordinateY;
        try {
            coordinateY = Checker.floatChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Y должно быть типа float" + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateY >= 840) {
            System.out.println("Coordinate y должно быть меньше 840");
            return;
        }

        route.setCoordinates(new Coordinates(coordinateX, coordinateY));
        Add.hasCoordinates = true;
    }

    /**
     * Метод добавления поля from в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param route  объект
     */
    protected static void addFrom(Reader reader, Collection c, Route route){
        System.out.print("\n" + "Откуда? (from)" + "\n" + "long x = ");

        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        long locationFromX;
        try {
            locationFromX = Checker.longChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location From (X) должно быть типа long." + "\n Попробуем ещё разок!");
            return;
        }
        System.out.print("double y = ");
        double locationFromY;
        try {
            locationFromY = Checker.doubleChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location From (Y) должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("Имя откуда:  ");
        String locationFromName = reader.getLine()+"";
        if (locationFromName.equals("")) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        route.setFrom(new Location(locationFromX, locationFromY, locationFromName));
        Add.hasFrom = true;
    }


    /**
     * Метод добавления поля to в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param route  объект
     */
    protected static void addTo(Reader reader, Collection c, Route route) {
        System.out.print("\n" + "Куда? (to)" + "\n" + "long x = ");
        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        long locationToX;
        try {
            locationToX = Checker.longChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location To (X) должно быть типа long." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("double y = ");
        double locationToY;
        try {
            locationToY = Checker.doubleChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. location To (Y) должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("Имя куда:  ");
        String locationToName = reader.getLine()+"";
        if (locationToName.equals("") ) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }

        route.setTo(new Location(locationToX, locationToY, locationToName));
        Add.hasTo = true;
    }

    /**
     * Метод добавления поля distance в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param route  объект
     */
    protected static void addDist(Reader reader, Collection c, Route route){
        System.out.print("\n" + "Давай посмотрим, что у нас там с Distance. (float)  ");
        String s = reader.getLine()+"";
        if (s.equals("")) {
            System.out.println("Установлено значение distance = null. Такие вот дела.");
            Add.hasDist = true;
            return;
        }
        float distance;
        try {
            distance = Checker.floatChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. distance должно быть типа float." + "\n Попробуем ещё разок!");
            return;
        }
        if (!(distance > 1)) {
            System.out.println("Значение Distance должно быть больше 1");
            return;
        }
        route.setDistance(distance);
        Add.hasDist = true;
    }
}
