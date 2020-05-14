package Commands;
import Readers.*;
import Routes.Coordinates;
import Routes.Location;
import Routes.Route;

import java.io.IOException;

public class Update {
        static String description ="update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
        public static void update (Reader reader, Routes.Collection c, String s2) throws IOException {
                if (s2==null | s2.equals("")) {
                        System.out.println("кажется вы забыли ввести айди");
                        return;
                }

                long id = Checker.longChecker(s2);
                Route r = c.searchById(id);
                if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
                        return;
                }

               int index =  c.Routes.indexOf(r);

                System.out.print("\n" +"Давайте попробуем изменить элемент по введённому айди." + "\n" +
                        "Раньше его звали \""+ c.Routes.get(index).getName() +"\". Как вы хотите, чтобы его звали теперь? ");
                String name = reader.getLine();
                if (name == null | name.equals("")) {
                        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                        return;
                }



                System.out.print("\n" +"Раньше координаты были  "+  c.Routes.get(index).getCoordinates() +"\n" + "Координаты теперь будут" + "\n" + "X = ");
                int coordinateX = Checker.intChecker(reader.getLine());
                System.out.print("Y = ");
                float coordinateY = Checker.floatChecker(reader.getLine());

                System.out.print("\n" +"Раньше откуда было "+c.Routes.get(index).getFrom() +"\n" + "Откуда теперь? (from)" + "\n" + "x = ");
                long locationFromX = Checker.longChecker(reader.getLine());
                System.out.print("y = ");
                double locationFromY = Checker.doubleChecker(reader.getLine());
                System.out.print("Имя откуда:  ");
                String locationFromName = reader.getLine();
                if (locationFromName == null | locationFromName.equals("")) {
                        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                        return;
                }

                System.out.print("\n" +"Раньше куда было "+c.Routes.get(index).getTo() + "\n" +"Куда теперь? (to)" + "\n" + "x = ");
                long locationToX = Checker.longChecker(reader.getLine());
                System.out.print("y = ");
                double locationToY = Checker.doubleChecker(reader.getLine());
                System.out.print("Имя куда:  ");
                String locationToName = reader.getLine();
                if (locationToName == null | locationToName.equals("")) {
                        System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
                        return;
                }
                System.out.print("\n" +"Раньше Distance было "+c.Routes.get(index).getDistance() +"\n" + "Давай посмотрим, что у нас там с Distance теперь.  ");
                float distance = Checker.floatChecker(reader.getLine());


                c.Routes.get(index).setName(name);
                c.Routes.get(index).setCoordinates(new Coordinates(coordinateX, coordinateY));
                c.Routes.get(index).setFrom(new Location(locationFromX, locationFromY, locationFromName));
                c.Routes.get(index).setTo(new Location(locationToX, locationToY, locationToName));
                c.Routes.get(index).setDistance(distance);

                System.out.println("\n" +"Вы достигли успеха в замене элемента по айди!");

        }
}
