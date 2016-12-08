package com.munteanu.lambdabasics;

/**
 * Created by romunteanu on 12/8/16.
 */
public class ThisReferenceExample {

  public void doProcess(int i, WowMuchWork wowMuchWork) {
    wowMuchWork.work(i);
  }

  public void execute() {
    doProcess(20, x -> {
      System.out.println(x);
      System.out.println(this);
    });
  }

  public static void main(String[] args) {

    ThisReferenceExample ref = new ThisReferenceExample();

    ref.doProcess(10, new WowMuchWork() {
      @Override
      public void work(int a) {
        System.out.println(a);
        System.out.println(this);
      }

      @Override
      public String toString() {
        return "Anonymous inner class";
      }
    });

    ref.execute();


    ref.doProcess(30, i -> {
      System.out.println(i);
      // "this" doesn't work here
      // System.out.println(this);
    });
  }

  @Override
  public String toString() {
    return "an instance of ThisReferenceExample";
  }
}

interface WowMuchWork {
  void work(int a);
}
