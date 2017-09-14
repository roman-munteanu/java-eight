package com.munteanu.model;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class Person {

    private String firstName;
    private String lastName;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName=").append(firstName)
            .append(", lastName=").append(lastName)
        .append("}");
        return sb.toString();
    }
}
