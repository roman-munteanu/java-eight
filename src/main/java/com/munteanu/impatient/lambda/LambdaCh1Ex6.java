package com.munteanu.impatient.lambda;

public class LambdaCh1Ex6 {
  public static void main(String[] args) {

    new Thread(uncheck(() -> {
      Thread.sleep(1000);
      System.out.println("Zzz");
    })).start();
  }

  public static Runnable uncheck(RunnableEx runner) {
    return () -> {
      try {
        runner.run();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    };
  }
}
