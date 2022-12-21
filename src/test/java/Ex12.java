import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex12 {
    @Test
    public void test() {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response resp = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers headers = resp.getHeaders();
        assertEquals("Some secret value", headers.getValue("x-secret-homework-header"), "Wrong value of HomeWork header: " + headers.getValue("x-secret-homework-header"));
    }
}
