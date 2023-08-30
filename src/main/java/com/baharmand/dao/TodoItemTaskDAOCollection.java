package com.baharmand.dao;

import com.baharmand.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private Collection<TodoItemTask> todoItemTasks;

    public TodoItemTaskDAOCollection() {
        todoItemTasks = new ArrayList<>();
    }


    @Override
    public void persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);

    }

    @Override
    public void remove(Integer id) {
        TodoItemTask taskToRemove = null;
        for (TodoItemTask task : todoItemTasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            todoItemTasks.remove(taskToRemove);
        }
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask task : todoItemTasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTasks) {
            if (task.isAssigned() == assigned) {
                result.add(task);
            }
        }
        return result;    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTasks) {
            if (task.getAssignee() != null && task.getAssignee().getId() == id) {
                result.add(task);
            }
        }
        return result;
    }
}
