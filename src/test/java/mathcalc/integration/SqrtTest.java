package mathcalc.integration;

import com.jayway.restassured.response.Response;
import helpers.ControllersUrlProvider;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SqrtTest {

    private static final String PROPER_VALUE = "64";

    @Before
    public void setUp() {
        baseURI = ControllersUrlProvider.SQRT_CALCULATION.getUrl();
    }

    @Test
    public void shouldReturnStatusOkWhenServiceIsUp() {
        given()
                .contentType("application/json")
                .when().get(PROPER_VALUE)
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldReturnStatusNotFoundWhenEmptyParamIsPassed() {
        given()
                .contentType("application/json")
                .when().get("")
                .then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void shouldCheckIfHeaderContainsAllFields() {
        given()
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Accept-Encoding", "gzip,deflate")
                .when().log().method().get();
    }

    @Test
    public void shouldReturn8WhenParamEquals64() {
        Response response =  given().contentType("application/json").when().get("64");
        String jsonString = response.asString();

        assertThat(jsonString, containsString("8.0"));
    }
}
