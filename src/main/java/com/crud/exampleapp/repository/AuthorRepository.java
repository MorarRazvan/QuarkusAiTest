package com.crud.exampleapp.repository;

import com.crud.exampleapp.model.Author;
import io.smallrye.mutiny.Uni;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@ApplicationScoped
public class AuthorRepository {

    @Inject
    JedisPool jedisPool;

    public Uni<Author> save(Author author) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.set(author.getId(), author.getName());
                return author;
            }
        });
    }

    public Uni<Author> findById(String id) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                String name = jedis.get(id);
                return new Author(id, name, Set.of()); // Simplified for example
            }
        });
    }

    public Uni<String> delete(String id) {
        return Uni.createFrom().item(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.del(id);
                return id;
            }
        });
    }
}