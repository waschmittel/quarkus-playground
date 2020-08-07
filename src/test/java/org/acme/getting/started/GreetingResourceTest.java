package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .pathParam("name", "daniel")
                .when().get("/hello/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello daniel, you are visitor #1."));
        given()
                .pathParam("name", "steffi")
                .when().get("/hello/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello steffi, you are visitor #2."));
        given()
                .pathParam("name", "daniel")
                .when().get("/hello/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello daniel, you are visitor #1."));
    }

}
