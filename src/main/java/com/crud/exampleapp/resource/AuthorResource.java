package com.crud.exampleapp.resource;

import com.crud.exampleapp.model.Author;
import com.crud.exampleapp.repository.AuthorRepository;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Inject
    AuthorRepository authorRepository;

    @GET
    @Path("/{id}")
    public Uni<Author> get(@PathParam("id") String id) {
        return authorRepository.findById(id);
    }

    @POST
    public Uni<Author> create(Author author) {
        return authorRepository.save(author);
    }

    @PUT
    public Uni<Author> update(Author author) {
        return authorRepository.save(author);
    }

    @DELETE
    @Path("/{id}")
    public Uni<String> delete(@PathParam("id") String id) {
        return authorRepository.delete(id);
    }
}