package com.baharmand;

public class Person {
    private static int lastId = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.id = ++lastId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("First name was null.");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("Last name was null.");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email was null.");
        this.email = email;
    }
    public String getSummary() {
        return "id: " + id + "First Name: " + firstName + "Last Name: " + lastName;
    }
}
