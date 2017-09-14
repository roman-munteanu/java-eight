package com.munteanu.lambdabasics;

/**
 * Created by romunteanu on 12/8/16.
 */
public class ClosuresExample {
  public static void main(String[] args) {

    int a = 10;
    final int b = 20;

    doProcess(a, new Process() {
      @Override
      public void process(int i) {
        System.out.println(i + b);
      }
    });

    doProcess(a, (i) -> System.out.println(i + b));

  }

  private static void doProcess(int i, Process process) {
    process.process(i);
  }
}

interface Process {
  void process(int i);
}
