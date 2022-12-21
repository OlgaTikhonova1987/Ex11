import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Ex11 {
    @Test
    public void test() {
        Map<String, String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response resp = RestAssured
                .given()
                .body(authData)
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> cookies = resp.getCookies();
        System.out.println(cookies);
        assertTrue(cookies.containsKey("HomeWork"), "There is no 'HomeWork' cookie");
        assertEquals("hw_value", resp.getCookie("HomeWork"), "Wrong value of HomeWork cookie: " + resp.getCookie("HomeWork"));
         }
    }
