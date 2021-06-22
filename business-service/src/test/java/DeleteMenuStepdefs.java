import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteMenuStepdefs {
    String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    HttpClient _client;
    HttpRequest _request;

    @And("I perform Delete for the menu number {string}")
    public void iPerformDeleteForTheMenuNumber() {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }

    @And("I perform Delete for the menu number {string}")
    public void iPerformDeleteForTheMenuNumber(String arg0) {
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
