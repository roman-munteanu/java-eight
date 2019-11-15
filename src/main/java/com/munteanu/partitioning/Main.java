package com.munteanu.partitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;

public class Main {
  public static void main(String[] args) {

    List<UserConfig> ls = new ArrayList<>();
    ls.add(new UserConfig(0, "alpha", "a"));
    ls.add(new UserConfig(0, "beta", "b"));
    ls.add(new UserConfig(1, "beta", "bbb"));
    ls.add(new UserConfig(1, "gamma", "g"));
    ls.add(new UserConfig(0, "delta", "d"));

    Map<Boolean, List<UserConfig>> configs = ls.stream().collect(partitioningBy(conf -> conf.getUserId() == 0));
//    System.out.println(configs);

//    Map<String, Long> m =  ls.stream().collect(groupingBy(UserConfig::getFieldName, counting()));
    Map<String, Integer> m =  ls.stream().collect(groupingBy(UserConfig::getFieldName, summingInt(UserConfig::getUserId) ));
//    System.out.println(m);

    List<String> defaultFields = m.entrySet().stream().filter(e -> e.getValue() == 0).map(Map.Entry::getKey).collect(Collectors.toList());
//    System.out.println(defaultFields);


    List<String> userFieldNames = ls.stream().filter(c -> c.getUserId() > 0).map(UserConfig::getFieldName).collect(Collectors.toList());

    List<UserConfig> defaultConfig = ls.stream().filter(c -> c.getUserId() == 0 && !userFieldNames.contains(c.getFieldName())).collect(Collectors.toList());

    System.out.println(defaultConfig);



  }
}

class UserConfig {

  private int userId;
  private String fieldName;
  private String fieldValue;

  public UserConfig(int userId, String fieldName, String fieldValue) {
    this.userId = userId;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }

  @Override
  public String toString() {
    return "UserConfig{" +
        "userId=" + userId +
        ", fieldName='" + fieldName + '\'' +
        ", fieldValue='" + fieldValue + '\'' +
        '}';
  }
}
