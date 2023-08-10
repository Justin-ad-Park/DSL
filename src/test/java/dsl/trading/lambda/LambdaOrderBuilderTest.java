package dsl.trading.lambda;

import domain.trading.stock.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * "Fluent" 또는 "Fluency"는 소프트웨어 개발에서 코드나 API의 사용성을 향상시키기 위한 디자인 패턴 중 하나를 나타냅니다.
 * Fluent API 또는 Fluent Interface라고도 합니다. 이 디자인 패턴은 메서드 체이닝을 통해 객체의 사용성을 향상시키고 코드의 가독성을 높이는 데 중점을 둡니다.
 *
 * Fluent 디자인 패턴의 주요 특징은 다음과 같습니다:
 *
 * 메서드 체이닝: 메서드가 항상 객체 자체를 반환하여 다른 메서드와 연결될 수 있습니다. 이를 통해 연속된 메서드 호출을 생성할 수 있습니다.
 * 읽기 쉬운 코드: 메서드 체이닝을 사용하면 코드가 "자연스러운 언어"와 유사하게 보일 수 있으므로 더욱 가독성이 좋아집니다.
 * 선언적 스타일: 원하는 결과를 얻기 위해 수행해야 할 일련의 작업을 선언적으로 나열할 수 있습니다.
 * 예를 들면, 빌더 패턴처럼 Fluent Interface를 사용하면 메서드 체이닝을 통해 간결하고 읽기 쉬운 코드를 작성할 수 있습니다.
 */
public class LambdaOrderBuilderTest {

    /**
     * DSL에 Lambda를 활용하면 메서드 체이닝 패턴처럼 플루언트 방식으로 DSL을 만들 수 있음
     *  메소드 체인 또는 중첩 함수 호출을 람다 표현식으로 대체
     *
     * 단점 :
     *  많은 설정 코드가 필요함
     *  자바8 람다 표현식 문법에 의한 잡음(비즈니스 표현과 무관한 코드)이 많아짐
     */
    @Test
    void LambdaBuilderTest() {
        Order order = LambdaOrderBuilder.order(o-> {
            o.forCustomer("Justin");
            o.buy(t -> {
                t.quantity(80);
                t.price(100.0);
                t.stock(s -> {
                    s.symbol("APPLE");
                    s.market("NASDAQ");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(1000.0);
                t.stock(s -> {
                    s.symbol("SAMSUNG");
                    s.market("KOSPI");
                });
            });
        });

        Assertions.assertEquals("Justin", order.getCustomer());

        Assertions.assertEquals(58000, order.getValue());
    }
}
