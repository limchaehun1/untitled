package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Deliveryconfirmed extends AbstractEvent {

    private Long id;
    private String address;
    private Long orderId;

    public Deliveryconfirmed(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveryconfirmed() {
        super();
    }
}
