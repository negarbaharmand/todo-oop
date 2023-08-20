package com.baharmand;

import java.util.Objects;

public class TodoItemTask {
    private static int lastId = 0;
    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this.id = ++lastId;
        this.assigned = (assignee != null);
        this.todoItem = todoItem;
        this.assignee = assignee;
    }


    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null ) {
            throw new IllegalArgumentException("Todo item description cannot be null or empty.");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        if (assignee == null) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        String assigneeInfo = assignee != null ? assignee.getFirstName() + " " + assignee.getLastName() : "Unassigned";
        return "id: " + id + " Assigned: " + assigned + " Assignee: " + assigneeInfo + " TodoItem: " + todoItem.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TodoItemTask task = (TodoItemTask) object;
        return id == task.id &&
                assigned == task.assigned &&
                Objects.equals(todoItem, task.todoItem) &&
                Objects.equals(assignee, task.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem, assignee);
    }
}
