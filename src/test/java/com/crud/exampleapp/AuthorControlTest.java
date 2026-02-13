package com.crud.exampleapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.crud.exampleapp.model.Author;
import com.crud.exampleapp.repository.AuthorRepository;

class AuthorControlTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorControl authorControl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAuthorById() {
        // Arrange
        Long authorId = 1L;
        Author mockAuthor = new Author();
        mockAuthor.setId(authorId);
        mockAuthor.setName("Test Author");

        when(authorRepository.findById(authorId)).thenReturn(mockAuthor);

        // Act
        Author result = authorControl.getAuthorById(authorId);

        // Assert
        assertNotNull(result);
        assertEquals(authorId, result.getId());
        assertEquals("Test Author", result.getName());
    }
}