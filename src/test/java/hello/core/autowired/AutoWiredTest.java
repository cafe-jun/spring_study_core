package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {


    @Test
    void AutoWirtedOptionTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    }

    static class TestConfig {
        /**
         * 참고: @Nullable, Optional은 스프링 전반에 걸쳐서 지원된다. 예를 들어서 생성자 자동 주입에서 특정 필드에만 사용해도 된다.
         *
         */
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 = " + member);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 = " + member);
        }

    }
}
