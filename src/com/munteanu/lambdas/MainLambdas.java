package com.munteanu.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class MainLambdas {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Pieter Igel", "Thomas Mohme", "Tobias Thiele", "Carsten Hierche", "Karsten Pfeiffer", "Jessica Oeklers");
        printList(names);

        /*
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        */

//        Collections.sort(names, (String a, String b) -> { return b.compareTo(a); });
        Collections.sort(names, (String a, String b) -> a.compareTo(b));

        printList(names);
    }

    public static <T> void printList(List<T> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }
}
