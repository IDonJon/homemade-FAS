import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetHomieAccountStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    @Given("I set GET homie service api endpoint")
    public void iSetGETHomieServiceApiEndpoint() {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }

    @When("I get a homie by performing GET operation for the homie number {string}")
    public void iGetAHomieByPerformingGETOperationForTheHomieNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        _request = request;
    }

    @Then("I should see the homie name as {string}")
    public void iShouldSeeTheHomieNameAs(String arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
