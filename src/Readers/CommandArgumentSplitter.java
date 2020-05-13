package Readers;


import Exceptions.NoCommandException;

public class CommandArgumentSplitter {

    public static String[] comArgSplitter(String readLine) throws NoCommandException {

        if (readLine != null) {
            
            readLine = readLine.trim();
            String [] ComArg = readLine.split(" ", 2);

            if (ComArg.length == 2) {
                ComArg[1] = ComArg[1].trim();
            }
            return ComArg;

        }

        throw new NoCommandException();

    }

}
