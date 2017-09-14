package com.munteanu.lambdabasics;

/**
 * Created by romunteanu on 11/28/16.
 */
public class Greeter {

  public void greet(Greeting greeting) {
    greeting.perform();
  }

  public static void main(String[] args) {

    Greeter greeter = new Greeter();

    greeter.greet(new Greeting() {
      @Override
      public void perform() {
        System.out.println("Hi!");
      }
    });

    greeter.greet(() -> System.out.println("Hola!"));

    // get string length
    StringLengthLambda stringLengthLambda = (str) -> str.length();
    System.out.println(stringLengthLambda.getLength("Hello!"));


    Thread myThread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Inside myThread");
      }
    });

    myThread.start();


    new Thread(() -> System.out.println("inside another thread")).start();


  }
}

interface StringLengthLambda {
  int getLength(String str);
}