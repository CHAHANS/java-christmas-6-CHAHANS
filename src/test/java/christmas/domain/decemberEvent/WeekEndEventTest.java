package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekEndEventTest {
    static WeekEndEvent weekEndEvent;

    @BeforeEach
    void setup() {
        this.weekEndEvent = new WeekEndEvent();
    }

    @DisplayName("금,토 이면서, 메인메뉴가 있어야만 true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9})
    void weekDayEventConditionCheckerTrueTest(int date) {
        Customer newCustomer = new Customer(date);
        newCustomer.addOrder("바비큐립", 2);
        assertThat(weekEndEvent.conditionChecker(newCustomer)).isTrue();
    }

    @DisplayName("금토가 아니면 false")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 24, 25})
    void weekDayEventConditionCheckerFalseTest(int date) {
        Customer newCustomer = new Customer(date);
        newCustomer.addOrder("바비큐립", 2);
        assertThat(weekEndEvent.conditionChecker(newCustomer)).isFalse();
    }

    @DisplayName("주문상품이 없는 경우 혜택금액 0")
    @Test
    void weekEndEventGetBenefitNullProductTest() {
        Customer newCustomer = new Customer(1);
        assertThat(newCustomer.getMyOrder().isEmpty()).isTrue();
        assertThat(weekEndEvent.getBenefit(newCustomer))
                .isEqualTo(0);
    }

    @DisplayName("메인메뉴 1개당 2023원씩 혜택금액 출력")
    @Test
    void weekEndEventGetBenefitTrueTest() {
        Customer newCustomer = new Customer(1);
        newCustomer.addOrder("티본스테이크", 1);
        newCustomer.addOrder("바비큐립", 2);
        assertThat(weekEndEvent.getBenefit(newCustomer))
                .isEqualTo(2023 * 3);
    }

    @DisplayName("메인메뉴 없는경우 0 출력")
    @Test
    void weekEndEventGetBenefitFalseTest() {
        Customer newCustomer = new Customer(1);
        newCustomer.addOrder("제로콜라", 1);
        newCustomer.addOrder("양송이스프", 2);
        assertThat(weekEndEvent.getBenefit(newCustomer))
                .isEqualTo(0);
    }

}