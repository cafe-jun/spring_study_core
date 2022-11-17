package orderapp.core.adapter.out.infrastructure.persistence;


import lombok.Getter;
import lombok.NoArgsConstructor;
import orderapp.core.application.order.port.out.OrderRecord;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "orderRecord")
public class OrderRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String orderId;
    private int money;

    public OrderRecordEntity(String orderId, int money) {
        this.orderId = orderId;
        this.money = money;
    }

    public static OrderRecordEntity from(OrderRecord orderRecord) {
        return new OrderRecordEntity(orderRecord.getOrderId(), orderRecord.getMoney());
    }
}
