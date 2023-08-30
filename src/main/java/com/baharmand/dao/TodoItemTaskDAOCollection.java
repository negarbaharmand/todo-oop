package com.baharmand.dao;

import com.baharmand.model.TodoItem;
import com.baharmand.model.TodoItemTask;

import java.util.Collection;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void persist(TodoItem todoItem) {

    }

    @Override
    public void remove(Integer integer) {

    }

    @Override
    public Collection<TodoItem> findAll() {
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        return null;
    }
}
