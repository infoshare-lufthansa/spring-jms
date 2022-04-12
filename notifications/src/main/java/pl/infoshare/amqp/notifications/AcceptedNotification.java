package pl.infoshare.amqp.notifications;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AcceptedNotification {

    private final Integer number;

    @JsonCreator
    public AcceptedNotification(@JsonProperty("number") Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
