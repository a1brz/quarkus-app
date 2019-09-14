package io.a1brz.app;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@QuarkusTest
class ControllerTest {
    @Test
    void testPingEndpoint() {
        given()
                .when().get("/ping")
                .then()
                .statusCode(200)
                .body(is("pong"));
    }
}