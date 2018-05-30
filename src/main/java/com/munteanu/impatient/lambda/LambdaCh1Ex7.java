package com.munteanu.impatient.lambda;

public class LambdaCh1Ex7 {
  public static void main(String[] args) {
    andThen(() -> {
      System.out.println("R1");
    }, () -> {
      System.out.println("R2");
    }).run();
  }

  public static Runnable andThen(Runnable r1, Runnable r2) {
    return () -> { r1.run(); r2.run(); };
  }
}
