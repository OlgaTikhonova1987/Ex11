import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Ex13 {
    @ParameterizedTest
    @CsvFileSource(resources = "some.csv", numLinesToSkip = 0, delimiterString = "**")
    public void test(String agent, String platform, String browser, String device) {
        JsonPath resp = RestAssured
                .given()
                .header("user-agent", agent)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();

        assertEquals(platform, resp.get("platform").toString(), "WRONG platform");
        assertEquals(browser, resp.get("browser").toString(), "WRONG browser");
        assertEquals(device, resp.get("device").toString(), "WRONG device");
    }

}
