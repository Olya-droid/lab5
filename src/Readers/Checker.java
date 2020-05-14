package Readers;

public class Checker {
    public static  Integer intChecker (String s) {
        if (s == null | s.equals("")) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return  null;}
        try {
            return Integer.parseInt(s);
        }catch (Exception e) {
            System.out.println("Ошибка ввода. Ну, с кем не бывает? Попробуйте еще раз");
            return null;
        }
    }

    public static Long longChecker (String s){
        if (s == null | s.equals("")) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return  null;}
        try {
            return Long.parseLong(s);
        }catch (Exception e) {
            System.out.println("Ошибка ввода. Ну, с кем не бывает? Попробуйте еще раз");
            return null;
        }

    }

    public static Float floatChecker (String s){
        if (s == null | s.equals("")) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return  null;}
        try {
            return Float.parseFloat(s);
        }catch (Exception e) {
            System.out.println("Ошибка ввода. Ну, с кем не бывает? Попробуйте еще раз");
            return null;
        }

    }

    public static Double doubleChecker (String s){
        if (s == null | s.equals("")) {
            System.out.println("Строка не читается или пустая. Попробуйте ещё разок, уверен, в следующий раз обязательно получится!");
            return  null;}
        try {
            return Double.parseDouble(s);
        }catch (Exception e) {
            System.out.println("Ошибка ввода. Ну, с кем не бывает? Попробуйте еще раз");
            return null;
        }

    }


}
