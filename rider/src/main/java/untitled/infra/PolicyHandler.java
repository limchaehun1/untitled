package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_LoaddeliveryInfo(@Payload Accepted accepted) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener LoaddeliveryInfo : " + accepted + "\n\n"
        );

        // Sample Logic //
        Delivery.loaddeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_LoaddeliveryInfo(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener LoaddeliveryInfo : " + ordered + "\n\n"
        );

        // Sample Logic //
        Delivery.loaddeliveryInfo(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AddressChanged'"
    )
    public void wheneverAddressChanged_LoaddeliveryInfo(
        @Payload AddressChanged addressChanged
    ) {
        AddressChanged event = addressChanged;
        System.out.println(
            "\n\n##### listener LoaddeliveryInfo : " + addressChanged + "\n\n"
        );

        // Sample Logic //
        Delivery.loaddeliveryInfo(event);
    }
}
