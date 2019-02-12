package com.munteanu.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class ItemHolder {
  String jobId;

  public ItemHolder(String jobId) {
    this.jobId = jobId;
  }
  public void showId() {
    System.out.println("ID: " + jobId);
  }
}

public class ConcurrentHashMapDemo {
  private static final ConcurrentMap<String, ItemHolder> map = new ConcurrentHashMap<>();

//  private static final Map<String, ItemHolder> map = new HashMap<>();

  private static void removeJobId(String jobId) {
    if (map.containsKey(jobId)) {
      ItemHolder ItemHolder = map.get(jobId);
      ItemHolder.showId();
      map.remove(jobId);
    }
  }

  public static void main(String[] args) {

    for (int i = 0; i < 1000000; i++) {
      String jobId = "id" + i;
      map.put(jobId, new ItemHolder(jobId));

      new Thread(() -> {
        removeJobId(jobId);
      }).start();

      new Thread(() -> {
        removeJobId(jobId);
      }).start();

      new Thread(() -> {
        removeJobId(jobId);
      }).start();
    }
  }
}
