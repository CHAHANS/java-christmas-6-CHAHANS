package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void set() {
        this.customer = new Customer(3);
    }

    @DisplayName("이미 있는 메뉴는 주문할 수 없음")
    @Test
    void orderAddFalseTest() {
        assertThat(customer.addOrder("샴페인",1)).isTrue();
        assertThat(customer.addOrder("샴페인",2)).isFalse();
    }

    @DisplayName("음료만 주문했는지 확인 할 수 있음")
    @Test
    void OnlyDrinkOrderTest() {
        customer.addOrder("샴페인",1);
        customer.addOrder("제로콜라",1);
        customer.addOrder("레드와인",1);
        assertThat(customer.checkOnlyDrinkOrder()).isTrue();
    }

}