import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BuyPaymentStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;
    @Given("I set up the creation of a new payment with POST operation for {string}")
    public void iSetUpTheCreationOfANewPaymentWithPOSTOperationFor(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }

    @When("I perform POST payment")
    public void iPerformPOSTPayment() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("payment1"))
                .build();
        _request = request;
    }

    @Then("I get a {int} status from the payment service")
    public void iGetAStatusFromThePaymentService(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
