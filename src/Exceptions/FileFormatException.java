package Exceptions;

public class FileFormatException extends Exception{
    public FileFormatException(){
        super("Входной файл некорректен либо пуст!");
    }
}
