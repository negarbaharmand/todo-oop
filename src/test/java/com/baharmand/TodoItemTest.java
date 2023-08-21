package com.baharmand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person("Test", "Testsson", "test@example.com");
    }

    @Test
    public void testIsOverdue() {
        LocalDate pastDate = LocalDate.now().minusDays(1);
        TodoItem overdueItem = new TodoItem("Title", "Description", pastDate, person);
        assertTrue(overdueItem.isOverdue());

        LocalDate futureDate = LocalDate.now().plusDays(1);
        TodoItem notOverdueItem = new TodoItem("Title", "Description", futureDate, person);
        assertFalse(notOverdueItem.isOverdue());
    }
    @Test
    public void testSetTitleNotNullOrEmpty() {
        TodoItem todoItem = new TodoItem("Title", "Description", LocalDate.now(), person);
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> todoItem.setTitle(""));
    }

}