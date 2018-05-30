package com.munteanu.impatient.lambda;

import org.apache.commons.io.filefilter.DirectoryFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LambdaCh1Ex2 {
  public static void main(String[] args) {

    File dir = new File("C:\\Users\\romunteanu\\Documents");

//    listFiles2(dir);
//    listFiles3(DirectoryFileFilter.INSTANCE, dir);

    for (File f : dir.listFiles(f -> f.isDirectory())) {
      System.out.println(f.getName());
    }
  }

  public static void listFiles(File file) {
    if (file.isDirectory()) {
      for (File f : file.listFiles()) {
        if (f.isDirectory()) {
          System.out.println(f.getName());
        }
      }
    }
  }

  public static void listFiles2(File file) {
    List<File> ls = Arrays.asList(file.listFiles());

    ls.forEach( (File f) -> {
     if (f.isDirectory()) {
       System.out.println(f.getName());
     }
    });
  }

  public static void listFiles3(FileFilter fileFilter, File file) {
    List<File> ls = Arrays.asList(file.listFiles());

    ls.forEach( f -> {
      if (fileFilter.accept(f)) {
        System.out.println(f.getName());
      }
    });
  }
}
