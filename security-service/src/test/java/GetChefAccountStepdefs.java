import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetChefAccountStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    @Given("I set GET chef service api endpoint")
    public void iSetGETChefServiceApiEndpoint() {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }

    @When("I get a chef by performing GET operation for the chef number {string}")
    public void iGetAChefByPerformingGETOperationForTheChefNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        _request = request;
    }

    @Then("I should see the chef name as {string}")
    public void iShouldSeeTheChefNameAs(String arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
