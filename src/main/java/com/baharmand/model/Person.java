package com.baharmand.model;

import com.baharmand.dao.sequencers.PersonSequencer;

import java.util.Objects;

public class Person {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credential;

    public Person(String firstName, String lastName, String email) {
        this.id = PersonSequencer.getCurrentId();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
