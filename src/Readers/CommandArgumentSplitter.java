package Readers;


import Exceptions.NoCommandException;

public class CommandArgumentSplitter {

    public static String[] comArgSplitter(String readLine) throws NoCommandException {

        if (readLine != null) {
            String [] ComArg = readLine.split(" ", 2);
            return ComArg;
        }

        throw new NoCommandException();

    }

}
