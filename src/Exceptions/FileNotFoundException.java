package Exceptions;

public class FileNotFoundException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Кажется, там нет такого файла. Попробуйте еще разок.";
    }
}
