package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @DisplayName("주문 갯수가 20개 초과시 애러")
    @Test
    void invalidEATest() {
        assertThatThrownBy(()->new Order("샴페인", 21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 주문인 경우, 정상적인 오더 금액 출력")
    @Test
    void calculateOrderPriceTest() {
        Order newOrder = new Order("샴페인", 10);
        int expect = 10*EventMenu.샴페인.getPrice();
        assertThat(newOrder.getOrderPrice()).isEqualTo(expect);
    }

}