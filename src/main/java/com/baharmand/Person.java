package com.baharmand;

import java.util.Objects;

public class Person {
    private static int lastId = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credential;

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

    public void setCredential(AppUser credential) {
        this.credential = credential;
    }

    public AppUser getCredential() {
        return credential;
    }

    @Override
    public String toString() {
        return "id: " + id + "First Name: " + firstName + "Last Name: " + lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(email, person.email) && id == person.id;
    }
}
