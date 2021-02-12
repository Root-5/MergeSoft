package utils;

import java.util.LinkedList;

public class ParserArgs {

    public static Options parse(String[] args) {
        Options options = new Options();
        options.inputFiles = new LinkedList<>();
        for (String arg : args) {
            switch (arg) {
                case "-d" -> options.sortOrder = 'd';
                case "-a" -> options.sortOrder = 'a';
                case "-s" -> options.dataType = 's';
                case "-i" -> options.dataType = 'i';
            }
            if (options.nameOutputFile == null && arg.contains(".")) {
                options.nameOutputFile = arg;
            } else if (arg.contains(".")) {
                options.inputFiles.add(arg);
            }
        }
        return options;
    }
}
