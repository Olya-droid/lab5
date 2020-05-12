package Exceptions;

public class WrongFileNameException extends Exception {
    public WrongFileNameException() {
        super("Файл с данным именем не найден!");
    }
}
