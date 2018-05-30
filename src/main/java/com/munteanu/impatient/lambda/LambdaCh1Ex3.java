package com.munteanu.impatient.lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class LambdaCh1Ex3 {
  public static void main(String[] args) {

    File dir = new File("C:\\Users\\romunteanu\\Documents");
    String ext = ".txt";

    FilenameFilter filenameFilter = (File d, String filename) -> {
      File f = new File(d.getAbsolutePath() + "\\" + filename);
      return f.isFile() && filename.endsWith(ext);
    };
    Arrays.asList(dir.list(filenameFilter)).forEach(System.out::println);
  }
}
