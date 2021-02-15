import utils.Options;

import java.util.ArrayList;


public class Sorter {

    public static ArrayList sort(Options options, ArrayList list1, ArrayList list2) {

        ArrayList result;
        if (options.dataType == 's') result = new ArrayList<String>();
        else result = new ArrayList<Integer>();

        switch (options.sortOrder) {
            case 'a': {
                switch (options.dataType) {
                    case 's': {
                        return Sorter.sortStrAsc(list1, list2);
                    }
                    case 'i': {
                        return Sorter.sortIntAsc(list1, list2);
                    }
                }
            }
            case 'd': {
                switch (options.dataType) {
                    case 's': {
                        return Sorter.sortStrDes(list1, list2);
                    }
                    case 'i': {
                        return Sorter.sortIntDes(list1, list2);

                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> sortIntAsc(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < (list1.size() + list2.size()); k++) {
            if (i >= list1.size()) {
                result.add(k, list2.get(j));
                j++;
            } else if (j >= list2.size()) {
                result.add(k, list1.get(i));
                i++;
            } else if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(k, list2.get(j));
                j++;
            }
        }
        return result;
    }

    public static ArrayList<Integer> sortIntDes(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < (list1.size() + list2.size()); k++) {
            if (i >= list1.size()) {
                result.add(k, list2.get(j));
                j++;
            } else if (j >= list2.size()) {
                result.add(k, list1.get(i));
                i++;
            } else if (list1.get(i) > list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(k, list2.get(j));
                j++;
            }
        }
        return result;
    }

    public static ArrayList<String> sortStrAsc(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < (list1.size() + list2.size()); k++) {
            if (i >= list1.size()) {
                result.add(k, list2.get(j));
                j++;
            } else if (j >= list2.size()) {
                result.add(k, list1.get(i));
                i++;
            } else if (isLower(list1.get(i), list2.get(j))) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(k, list2.get(j));
                j++;
            }
        }
        return result;
    }

    public static ArrayList<String> sortStrDes(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < (list1.size() + list2.size()); k++) {
            if (i >= list1.size()) {
                result.add(k, list2.get(j));
                j++;
            } else if (j >= list2.size()) {
                result.add(k, list1.get(i));
                i++;
            } else if (!isLower(list1.get(i), list2.get(j))) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(k, list2.get(j));
                j++;
            }
        }
        return result;
    }


    //First is lower than second?
    private static boolean isLower(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                return false;
            }
        }
        return s1.length() < s2.length();
    }
}
