package pl.infoshare.amqp.verifier.complaints;

import lombok.Value;

@Value
public class ComplaintResult {

    String result;
    Integer number;

    public static ComplaintResult accepted(Integer number) {
        return new ComplaintResult("ACCEPTED", number);
    }

    public static ComplaintResult rejected() {
        return new ComplaintResult("REJECTED", null);
    }
}
