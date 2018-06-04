package com.munteanu.impatient.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaCh1Ex9 {
  public static void main(String[] args) {

    Collection2<Integer> numbers = new ArrayList2<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    Consumer<Integer> cons = num -> System.out.println(num);
    Predicate<Integer> pred = num -> num % 2 == 0;
    numbers.forEachIf(cons, pred);
  }

  static class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {}
}
