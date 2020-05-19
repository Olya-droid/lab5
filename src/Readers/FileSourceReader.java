package Readers;


import Exceptions.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для чтения из файла 
 */
public class FileSourceReader extends Reader {

    private String path;

    public FileSourceReader(String path) throws java.io.FileNotFoundException {
        this.path = path;
        try {
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
    }

    @Override
    public String getLine(){
        try {
            System.out.print(bufferedReader.readLine() + "\n");
            return bufferedReader.readLine();
        } catch(IOException e){
            System.out.println("Ввод неожиданно прервался");
            return null;
        }
    }

}
