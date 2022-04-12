package pl.infoshare.amqp.webapp.complaints;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ComplaintVerifierClient {

    private final WebClient webClient;

    public ComplaintVerifierClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:8081")
                .build();
    }

    public VerificationResult verifyComplaint(Complaint complaint) {
        return this.webClient.post()
                .uri("/api/cases")
                .body(BodyInserters.fromValue(complaint))
                .retrieve()
                .toEntity(VerificationResult.class)
                .block()
                .getBody();
    }

}
