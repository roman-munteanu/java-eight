package com.munteanu.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Roman Munteanu on 9/16/17.
 */
public class FutureExample {
  public static void main(String[] args) {

//    Future future = CompletableFuture.completedFuture("Future value 1");
//
//    List<Future<String>> futureList = IntStream.range(1,7).boxed()
//      .map( (Integer n) -> CompletableFuture.completedFuture("Future value " + n))
//      .collect(toList());


    ExecutorService executor = Executors.newFixedThreadPool(1);

    List<Integer> numOfSeconds = Arrays.asList(2,5,4,7);

    List<Future<String>> results = numOfSeconds.stream().map(n -> executor.submit(() -> {
      TimeUnit.SECONDS.sleep(n);
      System.out.println("Request " + n + " finished");
      return "Content " + n;
    })).collect(toList());

    results.forEach(f -> System.out.println("isDone: " + f.isDone()));

    executor.shutdown();
  }
}
