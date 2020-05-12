package Readers;

import Exceptions.EndOfSourceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleSourceReader extends Reader{

    public ConsoleSourceReader(){
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getLine() throws EndOfSourceException {
        try {
            return bufferedReader.readLine();
        } catch(IOException e){
            throw new EndOfSourceException();
        }
    }

}
