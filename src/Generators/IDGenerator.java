package Generators;

public class IDGenerator {

    public static long generateNewID(){
        return (long) (1 + Math.random() * (Long.MAX_VALUE - 1));
    }

}
