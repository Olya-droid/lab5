package Readers;

import Exceptions.EndOfSourceException;
import Exceptions.WrongFileNameException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileSourceReader extends Reader {

    private String path;

    public FileSourceReader(String path) throws WrongFileNameException {
        this.path = path;
        try {
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new WrongFileNameException();
        }
    }

    @Override
    public String getLine() throws EndOfSourceException {
        try {
            System.out.print(bufferedReader.readLine() + "\n");
            return bufferedReader.readLine();
        } catch(IOException e){
            throw new EndOfSourceException();
        }
    }

}
