package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceConstructorTest {

    @Test
    void createOrder () {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"member1",Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA",10000);
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);

    }
}
