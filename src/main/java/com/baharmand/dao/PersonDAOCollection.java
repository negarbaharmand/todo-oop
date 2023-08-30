package com.baharmand.dao;

import com.baharmand.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOCollection implements PersonDAO {
    private Collection<Person> persons;

    public PersonDAOCollection() {
        persons = new ArrayList<>();
    }

    @Override
    public void persist(Person person) {
        persons.add(person);

    }

    @Override
    public void remove(Integer id) {
        Person personToRemove = null;
        for (Person person : persons) {
            if (person.getId() == id) {
                personToRemove = person;
                break;
            }
        }

        if (personToRemove != null) {
            persons.remove(personToRemove);
        }
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public Person findById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }
}
