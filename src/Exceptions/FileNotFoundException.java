package Exceptions;

public class FileNotFoundException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Кажется такого файла там нет";
    }
}
