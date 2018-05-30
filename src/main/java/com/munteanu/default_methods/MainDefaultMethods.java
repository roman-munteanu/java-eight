package com.munteanu.default_methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class MainDefaultMethods {
    public static void main(String[] args) {
//        Vehicle vehicle = new Car();
//        vehicle.print();

//        String s = "one two three";
        String s = "";

        List<String> res1 = extractItems(s);
        printList(res1);

        List<String> res2 = extractItems2(s);
        printList(res2);
    }

    private static List<String> extractItems(String s) {
        List<String> items;
        if (!"".equals(s)) {
            items = new ArrayList<String>(Arrays.asList(s.split(" ")));
        } else {
            items = new ArrayList();
        }
        return items;
    }

    private static List<String> extractItems2(String s) {
        return Arrays.asList(s.split(" "));
    }

    public static void printList(List<String> ls) {
        for (String item : ls) {
            System.out.println(item);
        }
        System.out.println("-----------------");
    }
}
