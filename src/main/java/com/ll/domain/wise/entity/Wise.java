package com.ll.domain.wise.entity;

public class Wise {
    private Long id;
    private String author;
    private String word;

    public Wise() {
    }

    public Wise(Long id, String author, String word) {
        this.id = id;
        this.author = author;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getWord() {
        return word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
