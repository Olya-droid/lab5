package Exceptions;

public class EndOfSourceException extends Exception {
    public EndOfSourceException(){
        super("Читать нечего!");
    }
}
