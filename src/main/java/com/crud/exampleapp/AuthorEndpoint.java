package com.crud.exampleapp;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorEndpoint {

    @Inject
    AuthorBoundary authorBoundary;

    @GET
    @Path("/{id}")
    public Uni<Author> get(@PathParam("id") String id) {
        return authorBoundary.getAuthor(id);
    }

    @POST
    public Uni<Author> create(Author author) {
        return authorBoundary.createAuthor(author);
    }

    @PUT
    public Uni<Author> update(Author author) {
        return authorBoundary.updateAuthor(author);
    }

    @DELETE
    @Path("/{id}")
    public Uni<String> delete(@PathParam("id") String id) {
        return authorBoundary.deleteAuthor(id);
    }
}