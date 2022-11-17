package orderapp.core.adapter.out.infrastructure.persistence;

import orderapp.core.application.order.port.out.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRecordRepoistory  extends JpaRepository<OrderRecordEntity,Long> {
    public Optional<OrderRecordEntity> findByOrderId(String orderId);
}
