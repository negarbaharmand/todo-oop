package com.baharmand.dao;

import com.baharmand.model.Person;
import com.baharmand.model.TodoItem;
import com.baharmand.model.TodoItemTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoItemTaskDAOCollectionTest {
    private TodoItemTaskDAOCollection todoItemTaskDAO;
    private Person person1;
    private TodoItem todoItem1;
    private TodoItem todoItem2;

    @BeforeEach
    void setUp() {
        todoItemTaskDAO = new TodoItemTaskDAOCollection();
        person1 = new Person("Negar", "BH", "negar@gmail");
        todoItem1 = new TodoItem("Task 1", "Water the plants", LocalDate.now(), person1);
        todoItem2 = new TodoItem("Task 2", "Wash the dishes", LocalDate.now(), person1);


    }

    @Test
    void testPersistAndFindById() {
        todoItemTaskDAO.persist(new TodoItemTask(todoItem1, person1));

        TodoItemTask task = new TodoItemTask(todoItem1, person1);
        todoItemTaskDAO.persist(task);

        TodoItemTask foundTask = todoItemTaskDAO.findById(task.getId());
        assertNotNull(foundTask);
        assertEquals(task.getId(), foundTask.getId());
        assertEquals(task.getTodoItem(), foundTask.getTodoItem());
    }

    @Test
    void testFindByAssignedStatus() {
        todoItemTaskDAO.persist(new TodoItemTask(todoItem1, person1));
        todoItemTaskDAO.persist(new TodoItemTask(todoItem2, null));

        Collection<TodoItemTask> assignedTasks = todoItemTaskDAO.findByAssignedStatus(true);
        assertEquals(1, assignedTasks.size());
    }
}
