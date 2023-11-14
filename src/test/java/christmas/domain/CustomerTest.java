package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void set() {
        this.customer = new Customer(3);
    }

    @DisplayName("이미 있는 메뉴는 주문할 수 없음")
    @Test
    void orderAddFalseTest() {
        customer.addOrder("샴페인",1);
        assertThatThrownBy(()->customer.addOrder("샴페인",2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문했는지 확인 후 애러")
    @Test
    void OnlyDrinkOrderTest() {
        customer.addOrder("샴페인",1);
        customer.addOrder("제로콜라",1);
        customer.addOrder("레드와인",1);
        assertThatThrownBy(()->customer.checkOnlyDrinkOrder())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 갯수가 20개 초과시 애러")
    @Test
    void invalidEATest() {
        assertThatThrownBy(()->customer.addOrder("레드와인", 21))
                .isInstanceOf(IllegalArgumentException.class);
    }

}