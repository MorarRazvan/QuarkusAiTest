package com.crud.exampleapp;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuthorControl {

    @Inject
    AuthorEntity authorEntity;

    public Uni<Author> getAuthor(String id) {
        return authorEntity.getAuthor(id);
    }

    public Uni<Author> createAuthor(Author author) {
        return authorEntity.createAuthor(author);
    }

    public Uni<Author> updateAuthor(Author author) {
        return authorEntity.updateAuthor(author);
    }

    public Uni<String> deleteAuthor(String id) {
        return authorEntity.deleteAuthor(id);
    }
}