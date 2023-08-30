package com.baharmand.dao;

import com.baharmand.model.Person;
import com.baharmand.model.TodoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TodoItemDAOCollectionTest {
    private TodoItemDAOCollection todoItemDAO;
    private Person person1;
    private TodoItem todoItem1;
    private TodoItem todoItem2;

    @BeforeEach
    void setUp() {
        todoItemDAO = new TodoItemDAOCollection();
        person1 = new Person("Negar", "BH", "negar@gmail");
        todoItem1 = new TodoItem("Task 1", "Water the plants", LocalDate.now(), person1);
        todoItem2 = new TodoItem("Task 2", "Wash the dishes", LocalDate.now(), person1);
    }

    @Test
    void testPersistAndFindById() {
        todoItemDAO.persist(todoItem1);

        TodoItem foundItem = todoItemDAO.findById(todoItem1.getId());
        assertNotNull(foundItem);
        assertEquals(todoItem1.getId(), foundItem.getId());
        assertEquals(todoItem1.getTitle(), foundItem.getTitle());
        assertEquals(todoItem1.getTaskDescription(), foundItem.getTaskDescription());
        assertEquals(todoItem1.getDeadLine(), foundItem.getDeadLine());
        assertEquals(todoItem1.getCreator(), foundItem.getCreator());
    }

    @Test
    void testFindByTitleContains() {
        todoItemDAO.persist(todoItem1);
        todoItemDAO.persist(todoItem2);
        Collection<TodoItem> foundItems = todoItemDAO.findByTitleContains("Task");
        assertEquals(2, foundItems.size());
    }

}
