package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;

//@Primary
@MainDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAccount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAccount;
        } else{
            return 0;
        }
    }
}
