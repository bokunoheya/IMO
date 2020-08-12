package com.example.projectimo;

public class Note {
    private int priority;
    private String title;
    private String description;
    public Note(){

    }
    public Note(String title, String description, int priority){
        this.title=title;
        this.description=description;
        this.priority=priority;

    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

