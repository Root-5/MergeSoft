import utils.Options;

import java.net.Inet4Address;
import java.util.ArrayList;


public class Sorter {

    public static ArrayList<Integer> sortInt(ArrayList<Integer> list1, ArrayList<Integer> list2) {
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

    public static ArrayList<String> sortStr(ArrayList<String> list1, ArrayList<String> list2) {
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


    //First is lower than second?
    private static boolean isLower(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            }
            i++;
        }
        return false;
    }

}
