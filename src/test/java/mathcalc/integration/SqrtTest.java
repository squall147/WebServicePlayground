package mathcalc.integration;

import helpers.ControllersUrlProvider;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SqrtTest {

    @Before
    public void setUp() {
        baseURI = ControllersUrlProvider.SQRT_CALCULATION.getUrl();
    }

    @Test
    public void shouldReturn200WhenServiceIsUp() {
        given().contentType("application/json").when().get("64").then().statusCode(200);
    }

    @Test
    public void shouldReturn404WhenEmptyParamIsPassed() {
        given().contentType("application/json").when().get("").then().statusCode(404);
    }

    @Test
    public void shouldReturn8WhenParamEquals64() {
        given().contentType("application/json").when().get("64").then().statusCode(200).body("output", containsString("8.0"));
    }
}
