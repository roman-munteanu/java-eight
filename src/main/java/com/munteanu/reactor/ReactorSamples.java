package com.munteanu.reactor;

import reactor.core.publisher.Flux;

/**
 * Created by romunteanu on 11/20/17.
 */
public class ReactorSamples {
  public static void main(String[] args) {

    Flux<String> seq1 = Flux.just("alpha", "beta", "gamma");
    seq1.subscribe(System.out::println, null, () -> System.out.println("Done"));

    Flux<Integer> seq2 = Flux.range(1, 4).map(i -> {
      if (i % 2 == 0) throw new RuntimeException("Restricted value: " + i);
      return i;
    });
    seq2.subscribe(i -> System.out.println(i),
    error -> System.out.println("Error: " + error),
    () -> System.out.println("Done"));

  }
}
