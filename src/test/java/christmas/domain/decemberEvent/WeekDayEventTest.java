package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekDayEventTest {
    static WeekDayEvent weekDayEvent;

    @BeforeEach
    void setup() {
        this.weekDayEvent = new WeekDayEvent();
    }

    @DisplayName("평일이면서, 디저트가 있어야만 true")
    @ParameterizedTest
    @ValueSource(ints = {15, 28, 25})
    void weekDayEventConditionCheckerTrueTest(int date) {
        Customer newCustomer = new Customer(date);
        newCustomer.addOrder("초코케이크", 1);
        assertThat(weekDayEvent.conditionChecker(newCustomer)).isTrue();
    }

    @DisplayName("평일이 아니면 false")
    @ParameterizedTest
    @ValueSource(ints = {16, 23, 24})
    void weekDayEventConditionCheckerFalseTest(int date) {
        Customer newCustomer = new Customer(date);
        newCustomer.addOrder("초코케이크", 1);
        assertThat(weekDayEvent.conditionChecker(newCustomer)).isFalse();
    }

    @DisplayName("주문상품이 없는 경우 혜택금액 0")
    @Test
    void weekDayEventGetBenefitNullProductTest() {
        Customer newCustomer = new Customer(25);
        assertThat(newCustomer.getMyOrder().isEmpty()).isTrue();
        assertThat(weekDayEvent.getBenefit(newCustomer))
                .isEqualTo(0);
    }

    @DisplayName("디저트메뉴 1개당 2023원씩 혜택금액 출력")
    @Test
    void weekDayEventGetBenefitTrueTest() {
        Customer newCustomer = new Customer(25);
        newCustomer.addOrder("초코케이크", 1);
        newCustomer.addOrder("아이스크림", 2);
        assertThat(weekDayEvent.getBenefit(newCustomer))
                .isEqualTo(2023 * 3);
    }

    @DisplayName("디저트메뉴 없는경우 0 출력")
    @Test
    void weekDayEventGetBenefitFalseTest() {
        Customer newCustomer = new Customer(25);
        newCustomer.addOrder("타파스", 1);
        newCustomer.addOrder("바비큐립", 2);
        assertThat(weekDayEvent.getBenefit(newCustomer))
                .isEqualTo(0);
    }

}