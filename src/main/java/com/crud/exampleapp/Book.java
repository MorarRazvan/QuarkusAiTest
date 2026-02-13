package com.crud.exampleapp;

import java.util.Set;

public class Book {
    private String title;
    private String genre;
    private Set<String> authors;

    public Book() {
    }

    public Book(String title, String genre, Set<String> authors) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public void removeAuthor(String author) {
        authors.remove(author);
    }
}