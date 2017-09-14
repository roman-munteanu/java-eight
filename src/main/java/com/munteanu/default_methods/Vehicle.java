package com.munteanu.default_methods;

/**
 * Created by romunteanu on 1/12/2016.
 */
public interface Vehicle {
    default void print() {
        System.out.println("Vehicle!");
    }
    static void blowHorn() {
        System.out.println("Horn!");
    }
}
