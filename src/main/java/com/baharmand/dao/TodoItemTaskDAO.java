package com.baharmand.dao;

import com.baharmand.model.TodoItem;
import com.baharmand.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends BaseDAO<TodoItem, Integer>{
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int id);
}
