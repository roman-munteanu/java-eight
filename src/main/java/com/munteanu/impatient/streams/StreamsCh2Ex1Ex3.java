package com.munteanu.impatient.streams;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamsCh2Ex1Ex3 {
  public static void main(String[] args) throws Exception {

//    String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
    String contents = "Lorem Ipsum is simply dummy text of the printing and typesettingindustry. Lorem Ipsum has been the industry's standarddummytext ever since the 1500s, when an unknown printer took a galley of typeandscrambledit to make a type specimen book. It has survived not onlyfivecenturies, but also the leap into electronic typesetting, remainingessentiallyunchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

    int count = 0;
    long time11 = System.currentTimeMillis();
    for (String w : words) {
      if (w.length() > 12) count++;
    }
    long time12 = System.currentTimeMillis();
    System.out.println(count);
    System.out.println("Time for sequential operation: " + (time12 - time11));

    AtomicInteger concurrentCount = new AtomicInteger(0);
    long time21 = System.currentTimeMillis();
    words.parallelStream().forEach(w -> { if (w.length() > 12) concurrentCount.incrementAndGet(); } );
    long time22 = System.currentTimeMillis();
    System.out.println("Time for parallel operation: " + (time22 - time21));

    System.out.println(concurrentCount.get());

  }
}
