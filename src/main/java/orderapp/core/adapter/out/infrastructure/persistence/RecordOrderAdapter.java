package orderapp.core.adapter.out.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import orderapp.core.application.order.port.out.GetOrderRecordPort;
import orderapp.core.application.order.port.out.OrderRecord;
import orderapp.core.application.order.port.out.RecordOrderPort;

@RequiredArgsConstructor
public class RecordOrderAdapter implements RecordOrderPort, GetOrderRecordPort {

    private final OrderRecordRepoistory orderRecordRepoistory;


    @Override
    public OrderRecord getOrder(String orderId) {
        OrderRecordEntity orderRecord = orderRecordRepoistory.findByOrderId(orderId).orElseThrow(IllegalAccessError::new);
        return new OrderRecord(orderRecord.getOrderId(), orderRecord.getMoney());
    }

    @Override
    public void recordOrder(OrderRecord orderRecord) {
        orderRecordRepoistory.save(OrderRecordEntity.from(orderRecord));
    }
}
