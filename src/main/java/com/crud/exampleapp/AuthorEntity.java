package com.crud.exampleapp;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@ApplicationScoped
public class AuthorEntity {

    @Inject
    JedisPool jedisPool;

    public Uni<Author> getAuthor(String id) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                String name = jedis.get(id);
                return new Author(id, name, Set.of()); // Simplified for example
            }
        });
    }

    public Uni<Author> createAuthor(Author author) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.set(author.getId(), author.getName());
                return author;
            }
        });
    }

    public Uni<Author> updateAuthor(Author author) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.set(author.getId(), author.getName());
                return author;
            }
        });
    }

    public Uni<String> deleteAuthor(String id) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.del(id);
                return id;
            }
        });
    }
}