package orderapp.core.application.order.port.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderRecord {
    private String orderId;
    private int money;
}
