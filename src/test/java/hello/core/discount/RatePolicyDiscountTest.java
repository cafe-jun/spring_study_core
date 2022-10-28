package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RatePolicyDiscountTest {

    DiscountPolicy  discountPolicy = new RatePolicyDiscount();

    @Test
    @DisplayName("VIP는 10% 할인이 적용이 되어야한다")
    void vip_o() {
        // given
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP아닌 유저는 10% 할인이 제외 되어야한다")
    void vip_x() {
        // given
        Member member = new Member(1L,"memberVIP", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }


}