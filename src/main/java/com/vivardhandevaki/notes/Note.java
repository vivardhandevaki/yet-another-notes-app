package com.vivardhandevaki.notes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    protected Note() {
    }

    Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    Long getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getContent() {
        return content;
    }
}
