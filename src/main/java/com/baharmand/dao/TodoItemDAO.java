package com.baharmand.dao;

import com.baharmand.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends BaseDAO<TodoItem, Integer>{
    void remove(int id);

    TodoItem findById(int id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int id);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
}
