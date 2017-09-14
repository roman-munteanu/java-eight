package com.munteanu.lambdabasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Roman Munteanu on 12/4/16.
 */
public class LambdaExercise1 {
  public static void main(String[] args) {

    List<Person> people = Arrays.asList(new Person("Tom", "Green"), new Person("Alice", "Parker"), new Person("Jack", "Black"));

    // Step 1
    Collections.sort(people, (Person p1, Person p2) ->
      p1.getLastName().compareTo(p2.getLastName())
    );

// Step 2
    people.forEach((Person p) -> System.out.println(p));

// Step 3

    printConditionallyOld(people, new MyCondition() {
      @Override
      public boolean test(Person p) {
        return p.getLastName().startsWith("B");
      }
    });

    printConditionally(people, p -> p.getLastName().startsWith("G"));

  }

  private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
    for (Person p : people) {
      if (predicate.test(p)) {
        System.out.println(p);
      }
    }
    System.out.println("-----------------------");
  }

  private static void printConditionallyOld(List<Person> people, MyCondition condition) {
    for (Person p : people) {
      if (condition.test(p)) {
        System.out.println(p);
      }
    }
    System.out.println("-----------------------");
  }
}

@FunctionalInterface
interface MyCondition {
  boolean test(Person p);
}