package orderapp.core.application.order.port.in;

public interface PlaceOrderUseCase {
    OrderResult placeOrder(OrderRequest orderDetail);
}
