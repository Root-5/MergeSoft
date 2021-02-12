import utils.Options;
import utils.ParserArgs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Options options = ParserArgs.parse(args);
        System.out.println(
                "\nSort order: " + options.sortOrder +
                "\nData type: " + options.dataType +
                "\nOutput file name: " + options.nameOutputFile +
                "\nInput files: " + options.inputFiles
        );
    }
}
