package com.crud.exampleapp;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthorBoundary {

    @Inject
    AuthorControl authorControl;

    public Uni<Author> getAuthor(String id) {
        return authorControl.getAuthor(id);
    }

    public Uni<Author> createAuthor(Author author) {
        return authorControl.createAuthor(author);
    }

    public Uni<Author> updateAuthor(Author author) {
        return authorControl.updateAuthor(author);
    }

    public Uni<String> deleteAuthor(String id) {
        return authorControl.deleteAuthor(id);
    }
}