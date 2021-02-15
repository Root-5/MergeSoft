import utils.Options;
import utils.ParserArgs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // Parse the args
        Options options = ParserArgs.parse(args);
        System.out.println(
                "\nSort order: " + options.sortOrder +
                        "\nData type: " + options.dataType +
                        "\nOutput file name: " + options.nameOutputFile +
                        "\nInput files: " + options.inputFiles
        );

        // Try to create output file
        try {
            if (new File(options.nameOutputFile).createNewFile())
                System.out.println("File " + options.nameOutputFile + " was created!");
            else System.out.println("Error: can't create new out file");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Declare and initialize lists of values
        ArrayList list1;
        ArrayList list2;
        ArrayList result;

        if (options.dataType == 'i') {
            list1 = new ArrayList<Integer>();
            list2 = new ArrayList<Integer>();
        } else if (options.dataType == 's') {
            list1 = new ArrayList<String>();
            list2 = new ArrayList<String>();
        } else {
            System.out.println("Error: Data type entered incorrectly");
            return;
        }


        initializeLists(list1, list2, options.inputFiles.get(0), options.inputFiles.get(1), options);
        result = Sorter.sort(options, list1, list2);

        if (options.inputFiles.size() > 2) {
            for (int i = 2; i < options.inputFiles.size(); i++) {
                initializeList(list2, options.inputFiles.get(i), options);
                result = Sorter.sort(options, result, list2);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(options.nameOutputFile))) {
            for (Object ob : result) {
                writer.write(ob.toString() + '\n');
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void initializeList(ArrayList list, String nameFile, Options options) throws IOException {
        BufferedReader bufferedReader;
        list.clear();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile), StandardCharsets.UTF_8));
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find the input file: " + "\"" + nameFile + "\"" + "! Exit.");
            ex.printStackTrace();
            return;
        }
        String line;
        try {
            if (options.dataType == 's') {
                while ((line = bufferedReader.readLine()) != null) {
                    list.add(line);
                }
            } else {
                while ((line = bufferedReader.readLine()) != null) {
                    list.add(Integer.parseInt(line));
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: you probably entered the wrong argument! Exit");
            System.exit(0);
            //ex.printStackTrace();
        }
    }

    public static void initializeLists(ArrayList list1, ArrayList list2, String nameFile1, String nameFile2, Options options) throws IOException {
        BufferedReader reader1;
        BufferedReader reader2;
        try {
            reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile1), StandardCharsets.UTF_8));
            reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile2), StandardCharsets.UTF_8));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        String line1;
        String line2;

        try {
            if (options.dataType == 'i') {
                while ((line1 = reader1.readLine()) != null) {
                    list1.add(Integer.parseInt(line1));
                }
                while ((line2 = reader2.readLine()) != null) {
                    list2.add(Integer.parseInt(line2));
                }
            } else {
                while ((line1 = reader1.readLine()) != null) {
                    list1.add(line1);
                }
                while ((line2 = reader2.readLine()) != null) {
                    list2.add(line2);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: you probably entered the wrong argument! Exit.");
            System.exit(0);
            //ex.printStackTrace();
        }
    }


}
