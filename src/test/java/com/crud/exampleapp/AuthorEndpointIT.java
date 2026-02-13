package com.crud.exampleapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AuthorEndpointIT {

    @Test
    public void testGetAuthorEndpoint() {
        given()
          .when().get("/author/1")
          .then()
             .statusCode(200)
             .body(is("{\"id\":1,\"name\":\"Test Author\"}"));
    }
}