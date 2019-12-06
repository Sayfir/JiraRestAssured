package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestCalls {

    public static Response getRequest(String uri) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get(uri);
        return response;
    }

    public static Response postRequest(String uri, String jsonPayload) {
        RequestSpecification requestSpecification = RestAssured.given().body(jsonPayload);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(uri);
        return response;
    }

    public static Response putRequest(String uri, String jsonPayload) {
        RequestSpecification requestSpecification = RestAssured.given().body(jsonPayload);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(uri);
        return response;
    }

    public static Response deleteRequest(String uri, String jsonPayload) {
        RequestSpecification requestSpecification = RestAssured.given().body(jsonPayload);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(uri);
        return response;
    }
}
