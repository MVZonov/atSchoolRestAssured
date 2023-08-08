import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {
    @Test
    public void testGetWithParams() {
        Response response = given()
                .param("p1", "v1")
                .param("p2", "v2")
                .when()
                .get("http://httpbin.org/anything");

        assertEquals(200, response.getStatusCode());
        assertEquals("v1", response.jsonPath().getString("args.p1"));
        assertEquals("v2", response.jsonPath().getString("args.p2"));
    }

    @Test
    public void testPostWithJsonBody() {
        Response response = given()
                .contentType("application/json")
                .body("{\"parameter\": \"value\"}")
                .when()
                .post("http://httpbin.org/anything");

        assertEquals(200, response.getStatusCode());
        assertEquals("value", response.jsonPath().getString("json.parameter"));
    }

    @Test
    public void testGetWithBasicAuth() {
        given().auth()
                .basic("user", "password")
                .when()
                .get("http://httpbin.org/basic-auth/user/password")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPostWithJsonBody2() {
        Response response = given()
                .contentType("application/json")
                .body("{\"parameter\": \"value\"}")
                .when()
                .post("http://httpbin.org/anything");

        assertEquals(200, response.getStatusCode());
        assertEquals("value", response.jsonPath().getString("json.parameter"));
    }
}
