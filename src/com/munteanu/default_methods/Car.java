package com.munteanu.default_methods;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class Car implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("Car - print");
    }
}
