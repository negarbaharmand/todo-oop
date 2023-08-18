package com.baharmand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    private Person person1;

    @BeforeEach
    public void setup() {
      person1 = new Person("John", "Doe", "john@example.com");
    }

    @Test
    public void testGetSummary() {
        String expectedSummary = "id: " + person1.getId() + "First Name: " + person1.getFirstName() + "Last Name: " + person1.getLastName();
        assertEquals(expectedSummary, person1.getSummary());
    }


}