package rest.jira.API.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateIssue {

    public static String baseURI = "https://https://maps.googleapis.com";

    @Test
    public static void verifyGetRequest() {
        RestAssured.baseURI = baseURI;
        given()
                .param("location", "-33.8670522,151.1957362")
                .param("radius", "500")
                .param("type", "restaurant").

                when()
                .get("/maps.api/place/nearbysearch/json")

                .then()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .and().body("reults[0].geometry.viewport.northeast", equalTo("-33.86901546736"))
                .and().header("server", "pablo");
    }

    @Test
    public static void verifyPostResponse() {
        String requestBody = "{" +
                "\"location\":{ " +
                "\"lat\":-33.7834676," +
                "\"lng\":151.1564321}," +
                "\"accuracy\":50}";

        RestAssured.baseURI = baseURI;
        Response response = given()
                .queryParam("key", "AIzaSyb-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo")
                .body(requestBody)
                .when().post("/maps/api/place/nearbysearch/json")
                .then()
                .assertThat().statusCode(200)
                .and().body("status", equalTo("OK"))
                .extract().response();
        JsonPath jsonResponse = new JsonPath(response.asString());
        String placeId = jsonResponse.get("place_id");
    }
}
