package orderapp.core.application.order.port.out;

public interface GetOrderRecordPort {
    OrderRecord getOrder(String orderId);
}
