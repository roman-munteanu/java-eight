package com.munteanu.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Questions {
  public static void main(String[] args) {

    // hashcode and equals
    List<SomeObject> ls = new ArrayList<>();
    SomeObject obj1 = new SomeObject("1", "2");
    ls.add(obj1);

    boolean contains1 = ls.contains(new SomeObject("1", "2"));
    System.out.println("contains1: " + contains1); // false

    boolean contains2 = ls.contains(obj1);
    System.out.println("contains2: " + contains2); // true


    List<AnotherObject> ls2 = new ArrayList<>();
    AnotherObject obj2 = new AnotherObject("1", "2");
    ls2.add(obj2);

    boolean contains3 = ls2.contains(new AnotherObject("1", "2"));
    System.out.println("contains3: " + contains3); // true

    // compare by reference and value
    System.out.println("---------------");
    String a = "a";
    String b = a;
    String c = new String("a");
    String d = new String("a").intern();
    String e = a.replace("a","a");

    System.out.println(a == b); // true
    System.out.println(a == c); // false
    System.out.println(a == d); // true
    System.out.println(a == e); // false

    System.out.println(a.equals(b)); // true
    System.out.println(a.equals(c)); // true
    System.out.println(a.equals(d)); // true
    System.out.println(a.equals(e)); // true
  }
}

class SomeObject {
  private String value1;
  private String value2;

  public SomeObject(String value1, String value2) {
    this.value1 = value1;
    this.value2 = value2;
  }
}

class AnotherObject {
  private String value1;
  private String value2;

  public AnotherObject(String value1, String value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnotherObject that = (AnotherObject) o;
    return Objects.equals(value1, that.value1) &&
        Objects.equals(value2, that.value2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value1, value2);
  }
}