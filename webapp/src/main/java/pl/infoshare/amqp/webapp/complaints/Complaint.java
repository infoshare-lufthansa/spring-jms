package pl.infoshare.amqp.webapp.complaints;

import lombok.Value;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Value
public class Complaint {
    @NotBlank
    @Size(min = 10)
    String reason;
    @DecimalMin("0")
    BigDecimal amount;
    @Email
    String email;
}
