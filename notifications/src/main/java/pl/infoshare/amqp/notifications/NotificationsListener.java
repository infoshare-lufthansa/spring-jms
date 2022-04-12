package pl.infoshare.amqp.notifications;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationsListener {

    @JmsListener(destination = "notification.accepted")
    public void handleAccepted(AcceptedNotification acceptedNotification) {
        System.out.println("Congratulations, your complaint was accepted. Number of complaint: " + acceptedNotification.getNumber());
    }

    @JmsListener(destination = "notification.rejected")
    public void handleRejected() {
        System.out.println("You complaint was rejected.");
    }

}
