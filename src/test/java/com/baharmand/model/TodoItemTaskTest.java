package com.baharmand.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {
    private TodoItemTask assignedTask;
    private TodoItemTask unassignedTask;

    @BeforeEach
    public void setUp() {
        assignedTask = new TodoItemTask(new TodoItem("Title", "Description", null, new Person("Test", "Testsson", "test@example.com")), new Person("Negar", "Baharmand", "negar@example.com"));
        unassignedTask = new TodoItemTask(new TodoItem("Title", "Description", null, new Person("Test", "Testsson", "test@example.com")), null);
    }

    @Test
    public void testIsAssigned() {
        assertTrue(assignedTask.isAssigned());
        assertFalse(unassignedTask.isAssigned());
    }

    @Test
    public void testGetTodoItem() {
        assertEquals("Title", assignedTask.getTodoItem().getTitle());
        assertEquals("Title", unassignedTask.getTodoItem().getTitle());
    }

}