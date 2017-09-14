package com.munteanu.lambdabasics;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Roman Munteanu on 12/9/16.
 */
public class MethodReferenceExample {
  public static void main(String[] args) {

//    new Thread(() -> doSomething()).start();
    new Thread(MethodReferenceExample::doSomething).start();

    String[] names = {"Bob", "Alice", "George"};

//    printConditionally(names, name -> name.length() > 3, (name) -> System.out.println(name));
    printConditionally(names, name -> name.length() > 3, System.out::println);

//    Arrays.asList(names).forEach(name -> System.out.println(name));
    Arrays.asList(names).forEach(System.out::println);
  }

  private static void doSomething() {
    System.out.println("Holla!");
  }

  private static void printConditionally(String[] names, Predicate<String> predicate, Consumer<String> consumer) {
    for (String name : names) {
      if (predicate.test(name)) {
        consumer.accept(name);
      }
    }
  }
}
