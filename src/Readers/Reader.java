package Readers;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Reader {

    protected BufferedReader bufferedReader;

    public abstract String getLine() throws IOException;

}
