package com.baharmand.dao;

import com.baharmand.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class TodoItemDAOCollection implements TodoItemDAO {
    private Collection<TodoItem> todoItems;

    public TodoItemDAOCollection() {
        todoItems = new ArrayList<>();
    }

    @Override
    public void persist(TodoItem todoItem) {
        todoItems.add(todoItem);

    }

    @Override
    public void remove(int id) {
        TodoItem itemToRemove = null;
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            todoItems.remove(itemToRemove);
        }
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.isDone()) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int id) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getId() == id) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isBefore(date)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItems) {
            if (item.getDeadLine().isAfter(date)) {
                result.add(item);
            }
        }
        return result;
    }
}
