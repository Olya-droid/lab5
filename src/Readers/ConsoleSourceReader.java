package Readers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleSourceReader extends Reader{

    public ConsoleSourceReader(){
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

}
