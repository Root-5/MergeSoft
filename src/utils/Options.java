package utils;

import java.util.LinkedList;

public class Options {
    public char sortOrder;
    public char dataType;
    public String nameOutputFile;
    public LinkedList<String> inputFiles;

    Options() {
        sortOrder = 'a';                //By default
        nameOutputFile = null;
    }
}
