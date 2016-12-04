package com.munteanu.lambdabasics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Roman Munteanu on 12/4/16.
 */
public class LambdaUnit2 {
  public static void main(String[] args) {

    List<Person> people = Arrays.asList(new Person("Tom", "Green"), new Person("Alice", "Parker"), new Person("Jack", "Black"));

    printConditionally(people, p -> true, p -> System.out.println(p.getFirstName()));
  }

  private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
    for (Person p : people) {
      if (predicate.test(p)) {
        consumer.accept(p);
      }
    }
  }
}
