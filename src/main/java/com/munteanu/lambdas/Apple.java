package com.munteanu.lambdas;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class Apple {

    private int weight;
    private Color color;

    public Apple() {}

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
