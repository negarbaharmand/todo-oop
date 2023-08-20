package com.baharmand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setup() {
      person1 = new Person("John", "Test", "test@example.com");
      person2 = new Person("Kell", "Teston", "Kell@gmail.con");
    }

    @Test
    public void testToString() {
        String expectedSummary = "id: " + person1.getId() + "First Name: " + person1.getFirstName() + "Last Name: " + person1.getLastName();
        assertEquals(expectedSummary, person1.toString());
    }

    @Test
    public void testHashCode(){
        assertNotEquals(person2.hashCode(), person1.hashCode());
    }


}