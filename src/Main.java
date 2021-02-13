import utils.Options;
import utils.ParserArgs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        Options options = ParserArgs.parse(args);
        System.out.println(
                "\nSort order: " + options.sortOrder +
                        "\nData type: " + options.dataType +
                        "\nOutput file name: " + options.nameOutputFile +
                        "\nInput files: " + options.inputFiles
        );

        try {
            if (new File(options.nameOutputFile).createNewFile())
                System.out.println("File " + options.nameOutputFile + " was created!");
            else System.out.println("Error from creating file");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        ArrayList list1;
        ArrayList list2;
        ArrayList result;

        if (options.dataType == 'i') {
            list1 = new ArrayList<Integer>();
            list2 = new ArrayList<Integer>();
            result = new ArrayList<Integer>();
        } else {
            list1 = new ArrayList<String>();
            list2 = new ArrayList<String>();
            result = new ArrayList<String>();
        }

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(options.inputFiles.get(0)), StandardCharsets.UTF_8));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(options.inputFiles.get(1)), StandardCharsets.UTF_8));
        String line1;
        String line2;

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

        switch (options.sortOrder) {
            case 'a': {
                switch (options.dataType) {
                    case 's' -> {
                        result = Sorter.sortStr(list1, list2);
                    }
                    case 'i' -> {
                        result = Sorter.sortInt(list1, list2);
                    }
                }
            }
            case 'd': {

            }
        }

        if (options.dataType == 'i') {
            for(Object integer: result) {
                System.out.println(integer);
            }
        } else {
            for(Object str: result) {
                System.out.println(str);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(options.nameOutputFile))) {

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
