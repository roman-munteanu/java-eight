package com.munteanu.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Roman Munteanu on 9/16/17.
 */
public class ExecutorInvokeAllExample {
  public static void main(String[] args) {

    ExecutorService executor = Executors.newFixedThreadPool(1);

    List<Callable<String>> callables = Arrays.asList(
        () -> "task 1",
        () -> "task 2",
        () -> "task 3"
    );

    try {
      executor.invokeAll(callables)
          .stream()
          .map(future -> {
            try {
              return future.get();
            } catch (Exception e) {
              throw new IllegalStateException(e);
            }
          }).forEach(System.out::println);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Callable<Integer> task = () -> {
      TimeUnit.SECONDS.sleep(2);
      return 2513;
    };

    Future<Integer> futureResult = executor.submit(task);

    try {
      futureResult.get(1, TimeUnit.SECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }

    executor.shutdown();

  }
}
