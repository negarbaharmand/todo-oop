package com.baharmand;

import java.time.LocalDate;

public class TodoItem {
    private static int lastId = 0;
    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String description, LocalDate deadLine, Person creator) {
        this.id = ++lastId;
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
        if (title == null ) {
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


    public String getSummary() {
        return "id: " + id + " Title: " + title + " Description: " + taskDescription;
    }
}
