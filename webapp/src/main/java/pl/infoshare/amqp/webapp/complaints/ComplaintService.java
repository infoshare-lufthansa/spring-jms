package pl.infoshare.amqp.webapp.complaints;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
@RequiredArgsConstructor
public class ComplaintService {

    private final JmsTemplate jmsTemplate;
    private final ComplaintVerifierClient complaintVerifierClient;

    public void processComplaint(Complaint complaint) {
        var result = complaintVerifierClient.verifyComplaint(complaint);
        if (result.isAccepted()) {
            jmsTemplate.convertAndSend("notification.accepted", result);
        } else {
            jmsTemplate.convertAndSend("notification.rejected", "");
        }
    }
}
