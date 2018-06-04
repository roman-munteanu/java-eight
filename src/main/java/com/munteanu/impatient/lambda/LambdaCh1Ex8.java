package com.munteanu.impatient.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaCh1Ex8 {
  public static void main(String[] args) {

    String[] names = {"Roman", "Kirill", "Yaroslav"};
    List<Runnable> runners = new ArrayList<>();
    for (String name : names)
      runners.add(() -> System.out.println(name));
//    for (int i=0; i<names.length; i++)
//      runners.add(() -> System.out.println(names[i]));
    System.out.println("test");
  }
}
