package pl.infoshare.amqp.notifications;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

import java.util.Map;

@EnableJms
@SpringBootApplication
public class NotificationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationsApplication.class, args);
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.setPersistent(false);
        return broker;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_type");
        converter.setTypeIdMappings(Map.of("pl.infoshare.amqp.webapp.complaints.VerificationResult", AcceptedNotification.class));
        return converter;
    }
}
