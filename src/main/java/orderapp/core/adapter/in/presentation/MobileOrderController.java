package orderapp.core.adapter.in.presentation;

import lombok.RequiredArgsConstructor;
import orderapp.core.application.order.port.in.OrderRequest;
import orderapp.core.application.order.port.in.OrderResult;
import orderapp.core.application.order.port.in.PlaceOrderUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MobileOrderController {
    private final PlaceOrderUseCase placeOrderUseCase;

    @GetMapping("/mobile/{money}")
    public OrderResult order(@PathVariable int money) {
        OrderRequest orderRequest = new OrderRequest(money);
        return placeOrderUseCase.placeOrder(orderRequest);
    }
}
