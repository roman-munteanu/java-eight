package com.munteanu.future;

import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by romunteanu on 9/14/17.
 */
public class MainExecutorServiceSample {

  private static final int NUMBER_OF_THREADS = 4;

  public static void main(String[] args) {

    // Future<T> future = ConcurrentUtils.constantFuture(T myValue);

    // Future future = CompletableFuture.completedFuture("Future value 1");

//    List<Future<String>> futureList = IntStream.range(1,7).boxed()
//      .map( (Integer n) -> CompletableFuture.completedFuture("Future value " + n))
//      .collect(toList());

    final List<String> sites = Arrays.asList("https://www.google.com", "https://www.yandex.ru", "http://gemheap.herokuapp.com");

    ExecutorService es = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(es);

    for (String site : sites) {
//      completionService.submit(new Callable<String>() {
//        @Override
//        public String call() throws Exception {
//          return IOUtils.toString(new URL(site).openStream());
//        }
//      });
      completionService.submit(() -> IOUtils.toString(new URL(site).openStream()) );
    }

    for (int i=0; i < sites.size(); i++) {
      try {
        Future<String> futureResult = completionService.take();

        System.out.println(i+1 + ":");
        String result = futureResult.get();
        System.out.println(result);

      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }


    es.shutdown();

  }
}
