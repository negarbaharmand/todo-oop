package com.baharmand.dao;

import com.baharmand.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOCollectionTest {
    private PersonDAOCollection personDAO;
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp() {
        personDAO = new PersonDAOCollection();
        person1 = new Person("Negar", "Baharmand", "negar@example.com");
        person2 = new Person("Jennifer", "Lopez", "jennifer@example.com");
    }
    @Test
    void testPersistAndFindById() {
        personDAO.persist(person1);

        Person foundPerson = personDAO.findById(person1.getId());
        assertNotNull(foundPerson);
        assertEquals(person1.getId(), foundPerson.getId());
        assertEquals(person1.getFirstName(), foundPerson.getFirstName());
        assertEquals(person1.getLastName(), foundPerson.getLastName());
        assertEquals(person1.getEmail(), foundPerson.getEmail());
    }
    @Test
    void testFindByEmail() {
        personDAO.persist(person1);
        personDAO.persist(person2);

        Person foundPerson = personDAO.findByEmail(person1.getEmail());
        assertNotNull(foundPerson);
        assertEquals(person1.getEmail(), foundPerson.getEmail());

        foundPerson = personDAO.findByEmail("jlo@example.com");
        assertNull(foundPerson);
    }
    @Test
    void testFindAll() {
        personDAO.persist(person1);
        personDAO.persist(person2);

        assertEquals(2, personDAO.findAll().size());
    }

}