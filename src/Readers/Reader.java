package Readers;

import Exceptions.WrongFileNameException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class FileSourceReader extends Reader {

    private String path;

    public FileSourceReader(String path) throws WrongFileNameException {
        this.path = path;
        try {
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new WrongFileNameException("Файл с данным именем не найден!");
        }
    }

    
}
