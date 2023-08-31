package com.baharmand.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {
    private TodoItemTask assignedTask;
    private TodoItemTask unassignedTask;
    private Person assignee;
    private TodoItem todoItem;

    @BeforeEach
    public void setUp() {
        assignee = new Person("Negar", "BAharmand", "negar@example.com");
        assignedTask = new TodoItemTask(new TodoItem("Title", "Description", null, new Person("Test", "Testsson", "test@example.com")), assignee);
        unassignedTask = new TodoItemTask(new TodoItem("Title", "Description", null, new Person("Test", "Testsson", "test@example.com")), null);
        todoItem = new TodoItem("Task 1", "Description", LocalDate.now(), assignee);
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

    @Test
    void testSetAssignee() {

        assertEquals(assignee, assignedTask.getAssignee());
        assertTrue(assignedTask.isAssigned());

        Person newAssignee = new Person("Jennifer", "Lopez", "jenni@example.com");
        assignedTask.setAssignee(newAssignee);
        assertTrue(assignedTask.isAssigned());
        assertEquals(newAssignee, assignedTask.getAssignee());
        assertFalse(unassignedTask.isAssigned());


    }

}