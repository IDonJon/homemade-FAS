import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetChefStepdefs {
    String POSTS_API_URL = "https://jsonplaceholder.typicode.com/chefs";
    HttpClient _client;
    HttpRequest _request;


    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        _request = request;
    }


    @And("I perform GET for the chef number {string}")
    public void iPerformGETForTheChefNumber(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }



    @Then("I should see the chef name as {string}")
    public void iShouldSeeTheChefNameAs(String arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);

    }
}
