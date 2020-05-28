package Readers;

import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для чтения из файла
 */

public class FileSourceReader extends Reader {

    public FileSourceReader(String path) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Ошибка чтения файла");;
        }
    }

    @Override
    public String getLine(){
        try {
            String s = bufferedReader.readLine();
            if (s!= null){
                System.out.print(s + "\n");
            }
            return s;
        } catch(IOException e){
            System.out.println("Ввод неожиданно прервался");
            return null;
        }
    }
}
