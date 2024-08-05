package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class APISteps {
    private Response response;

    @Given("I send a GET request to comments endpoint with name {string}")
    public void i_send_a_get_request_to_comments_endpoint_with_name(String name) {
        RequestSpecification request = RestAssured.given();
        request.queryParam("name", name);
        response = request.get("https://jsonplaceholder.typicode.com/comments");
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the email should be {string}")
    public void the_email_should_be(String email) {
        String actualEmail = response.jsonPath().getString("find { it.name == 'alias odio sit' }.email");
        Assert.assertEquals(email, actualEmail);
    }

    @Given("I send a POST request to users endpoint with name {string}, username {string} and email {string}")
    public void i_send_a_post_request_to_users_endpoint_with_name_username_and_email(String name, String username, String email) {
        String requestBody = String.format("{\"name\":\"%s\",\"username\":\"%s\",\"email\":\"%s\"}", name, username, email);
        response = RestAssured.given().header("Content-Type", "application/json").body(requestBody).post("https://jsonplaceholder.typicode.com/users");
    }

    @Then("the response should contain an id")
    public void the_response_should_contain_an_id() {
        Integer id = response.jsonPath().get("id");
        Assert.assertNotNull(id);
    }

    @Given("I send a PUT request to update user with id 5")
    public void i_send_a_put_request_to_update_user_with_id_5() {
        String requestBody = "{\"email\":\"updatedemail@example.com\",\"address\":{\"geo\":{\"lat\":\"-37.3159\",\"lng\":\"81.1496\"}}}";
        response = RestAssured.given().header("Content-Type", "application/json").body(requestBody).put("https://jsonplaceholder.typicode.com/users/5");
    }

    @Then("the response email should be {string}")
    public void the_email_should_be_for_the_updated_user(String email) {
        String actualEmail = response.jsonPath().getString("email");
        Assert.assertEquals(email, actualEmail);
    }

    @Then("the response lat should be {string}")
    public void the_lat_should_be(String lat) {
        String actualLat = response.jsonPath().getString("address.geo.lat");
        Assert.assertEquals(lat, actualLat);
    }

    @Then("the response lng should be {string}")
    public void the_response_lng_should_be(String lng) {
        String actualLng = response.jsonPath().getString("address.geo.lng");
        Assert.assertEquals(lng, actualLng);
    }
}