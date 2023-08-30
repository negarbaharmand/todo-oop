package com.baharmand.model;

import com.baharmand.dao.sequencers.TodoItemSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String description, LocalDate deadLine, Person creator) {
        this.id = TodoItemSequencer.getCurrentId();
        this.title = title;
        this.taskDescription = description;
        this.deadLine = deadLine;
        this.creator = creator;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("Deadline cannot be null.");
        }
        this.deadLine = deadLine;
    }


    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isDone() {
        return done;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }


    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "id: " + id + " Title: " + title + " Description: " + taskDescription
                + " Deadline: " + deadLine + " Done: " + done + " Creator: " + creator.getFirstName() + " " + creator.getLastName();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TodoItem todoItem = (TodoItem) object;
        return id == todoItem.id &&
                done == todoItem.done &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(taskDescription, todoItem.taskDescription) &&
                Objects.equals(deadLine, todoItem.deadLine) &&
                Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done, creator);
    }
}
