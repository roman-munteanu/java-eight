package com.munteanu.default_methods;

/**
 * Created by romunteanu on 1/12/2016.
 */
public interface FourWheeler {
    default void print() {
        System.out.println("FourWheeler!");
    }
}
