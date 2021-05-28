import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteRecipeStepdefs {
    String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    HttpClient _client;
    HttpRequest _request;

    @Given("I perform Delete operation for")
    public void iPerformDeleteOperationFor() {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }

    @And("I perform Delete for the recipe number {string}")
    public void iPerformDeleteForTheRecipeNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        _request = request;
    }

    @Then("I get a {int} status")
    public void iGetAStatus(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
