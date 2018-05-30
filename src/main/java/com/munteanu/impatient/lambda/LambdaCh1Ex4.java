package com.munteanu.impatient.lambda;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaCh1Ex4 {
  public static void main(String[] args) {

    File dir = new File("C:\\Users\\romunteanu\\Documents");

    Comparator<File> comp = (f1, f2) -> {
      if (f1.isDirectory() && !f2.isDirectory()) return -1;
      else if (!f1.isDirectory() && f2.isDirectory()) return 1;
      else return f1.getName().compareTo(f2.getName());
    };

    File[] files = dir.listFiles();
    Arrays.sort(files, comp);

    Arrays.asList(files).stream().map(f -> f.getName()).forEach(System.out::println);

  }
}
