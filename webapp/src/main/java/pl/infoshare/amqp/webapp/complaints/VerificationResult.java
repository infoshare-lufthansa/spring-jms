package pl.infoshare.amqp.webapp.complaints;

import lombok.Value;

import java.util.Objects;

@Value
public class VerificationResult {

    String result;
    Integer number;

    public boolean isAccepted() {
        return Objects.equals(result, "ACCEPTED");
    }

}
