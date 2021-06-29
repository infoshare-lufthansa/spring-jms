package pl.infoshare.amqp.verifier.complaints;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Complaint {
    String reason;
    BigDecimal amount;
}
