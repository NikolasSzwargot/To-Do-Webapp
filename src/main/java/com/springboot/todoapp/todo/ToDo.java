package com.springboot.todoapp.todo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class ToDo {
    private int id;
    private String ownerUsername;
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public ToDo(int id, String ownerUsername, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.ownerUsername = ownerUsername;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
