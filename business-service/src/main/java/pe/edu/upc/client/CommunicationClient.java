package pe.edu.upc.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.models.Comment;


@FeignClient(name = "communication-service", fallback = CommunicationHystrixFallbackFactory.class)
public interface CommunicationClient {
    @GetMapping(value = "/comment/{id}")
    public ResponseEntity<Comment>getComment(@PathVariable("id") long id);
}
