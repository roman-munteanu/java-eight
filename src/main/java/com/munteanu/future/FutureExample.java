package com.munteanu.future;

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

    executor.submit(() -> {
      TimeUnit.SECONDS.sleep(2);
      return "Content";
    });

  }
}
