package orderapp.core.application.order.service;

import lombok.RequiredArgsConstructor;
import orderapp.core.application.order.port.in.OrderRequest;
import orderapp.core.application.order.port.in.OrderResult;
import orderapp.core.application.order.port.in.PlaceOrderUseCase;
import orderapp.core.application.order.port.out.OrderRecord;
import orderapp.core.application.order.port.out.RecordOrderPort;
import orderapp.core.domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlacesOrderService implements PlaceOrderUseCase {

    private final RecordOrderPort recordOrderPort;
    @Transactional
    @Override
    public OrderResult placeOrder(OrderRequest orderDetail) {
        Order order = new Order(UUID.randomUUID().toString(),orderDetail.getMoney());
        order.place();
        recordOrderPort.recordOrder(new OrderRecord(order.getId(), order.getMoney()));
        return new OrderResult(order.getId(), order.getMoney());
    }
}
