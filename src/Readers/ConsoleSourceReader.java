package Readers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleSourceReader extends Reader{

    public ConsoleSourceReader(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

}
