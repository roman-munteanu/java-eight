package com.munteanu.future;

import java.util.concurrent.*;

/**
 * Created by Roman Munteanu on 9/16/17.
 */
public class ExecutorServiceExample {
  public static void main(String[] args) {

    // Single thread pool with Runnable

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Runnable task1 = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Thread name: " + threadName);
    };
    System.out.println("Main thread: " + Thread.currentThread().getName());

    executor.submit(task1);

    try {
      executor.shutdown();
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (!executor.isShutdown()) {
        System.err.println("Cancelling non-finished tasks!");
      }
      executor.shutdownNow();
      System.out.println("shutdownNow finished");
    }

    // Fixed thread pool with Callable

    ExecutorService executor2 = Executors.newFixedThreadPool(1);

    Callable<String> task2 = () -> {
      try {
        TimeUnit.SECONDS.sleep(5);
        return "task2: Result";
      } catch (InterruptedException e) {
        throw new IllegalStateException("task2 interrupted", e);
      }
    };

    Future<String> futureResult = executor2.submit(task2);

    System.out.println("Future is done: " + futureResult.isDone());

    String result = "Default result";
    try {
      result = futureResult.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    System.out.println("Future is done: " + futureResult.isDone());
    System.out.println("Result: " + result);

    executor2.shutdown();
  }
}
