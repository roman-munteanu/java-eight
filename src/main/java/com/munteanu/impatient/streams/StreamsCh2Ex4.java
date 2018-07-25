package com.munteanu.impatient.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCh2Ex4 {
  public static void main(String[] args) {

    int[] values = {1, 4, 9, 16};

    Stream<int[]> arr = Stream.of(values);
    arr.forEach(System.out::println);

    IntStream arr2 = IntStream.of(values);
    arr2.forEach(System.out::println);

  }
}
