package com.munteanu.lambdabasics;

import java.util.function.BiConsumer;

public class LambdaHandleExxceptions {
  public static void main(String[] args) {

    int[] arr = {1,2,3,4};
    int val = 0;

    process(arr, val, wrapperLambda((a, b) -> System.out.println(a / b)) );

  }

  private static void process(int[] arr, int val, BiConsumer<Integer, Integer> consumer) {
    for (int num : arr) {
      consumer.accept(num, val);
    }
  }

  private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
    return (a, b) -> {
      try {
        consumer.accept(a, b);
      } catch (ArithmeticException ex) {
        System.out.println("Exception from wrapper lambda");
      }
    };
  }
}
