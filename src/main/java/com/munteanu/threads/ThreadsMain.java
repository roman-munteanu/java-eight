package com.munteanu.threads;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ThreadsMain {
  public static void main(String[] args) throws InterruptedException {

//    try {
//      Process p = Runtime.getRuntime().exec("java -version");
//
//      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//      String line = null;
//      while ((line = br.readLine()) != null) {
//        System.out.println(line);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }


    ServiceContent sc1 = new ServiceContent();
    sc1.setUrl("https://www.google.com");

    ServiceContent sc2 = new ServiceContent();
    sc2.setUrl("https://www.yandex.ru");

    sc1.start();
    sc2.start();

    sc1.join();
    sc2.join();

    System.out.println(sc1.getContent());
    System.out.println(sc2.getContent());

  }

  static class ServiceContent extends Thread {
    private String url;
    private String content;

    @Override
    public void run() {
      try {
        content = IOUtils.toString(new URL(url).openStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }
  }
}
