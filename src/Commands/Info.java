package Commands;

public class Info {
    static String description ="info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    public static void info(Routes.Collection c) {
        System.out.println("Тип коллекции: " + c.Routes.getClass().getName());
        System.out.println("Колличество элементов: " + c.Routes.size());
        System.out.println("Коллеция создана: " + c.getInitializationDate());
    }
}
