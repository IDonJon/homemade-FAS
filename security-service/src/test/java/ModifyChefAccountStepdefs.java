import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModifyChefAccountStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;
    @Given("I set up the modification of a chef account with PUT operation for {string}")
    public void iSetUpTheModificationOfAChefAccountWithPUTOperationFor(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }

    @And("I perform PUT for the chef number {string}")
    public void iPerformPUTForTheChefNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("chef1"))
                .build();
        _request = request;
    }

    @Then("I get a {int} status from modify chef service")
    public void iGetAStatusFromModifyChefService(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}