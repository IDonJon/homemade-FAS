import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModifyHomieAccountStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;
    @Given("I set up the modification of a homie account with PUT operation for {string}")
    public void iSetUpTheModificationOfAHomieAccountWithPUTOperationFor(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }

    @And("I perform PUT for the homie number {string}")
    public void iPerformPUTForTheHomieNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("homie1"))
                .build();
        _request = request;
    }

    @Then("I get a {int} status from modify homie service")
    public void iGetAStatusFromModifyHomieService(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
