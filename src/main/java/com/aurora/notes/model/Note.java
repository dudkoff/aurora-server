package com.aurora.notes.model;

import java.util.Date;

public class Note {
    private Long id;
    private String text;
    private Date created;
    private String author;

    public Note(Long id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.created = new Date();
    }

    public Note() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
