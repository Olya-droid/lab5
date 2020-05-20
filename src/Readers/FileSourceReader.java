package Readers;


import Exceptions.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
/**
 * Класс для чтения из файла
 */
public class FileSourceReader extends Reader {

    public FileSourceReader(String path) throws java.io.FileNotFoundException {
        try {
            File script = new File(path);
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public String getLine(){
        try {
            String s = bufferedReader.readLine();
           System.out.print( s + "\n");
            return s;
        } catch(IOException e){
            System.out.println("Ввод неожиданно прервался");
            return null;
        }
    }

}
