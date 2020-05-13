package Exceptions;

public class NoCommandException extends Exception{
   public NoCommandException(){
       super("Команда не была введена!");
   }

}
