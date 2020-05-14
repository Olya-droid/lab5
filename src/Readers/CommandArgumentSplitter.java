package Readers;

public class CommandArgumentSplitter {

    public static String[] comArgSplitter(String readLine) {

        if (readLine != null) {

            readLine = readLine.trim();
            String [] ComArg = readLine.split(" ", 2);

            if (ComArg.length == 2) {
                ComArg[1] = ComArg[1].trim();
                return ComArg;
            } else
                return new String[]{ComArg[0], ""};

        }

        System.out.println("Вы не ввели команду. Попробуйте еще раз");
        return null;

    }

}
