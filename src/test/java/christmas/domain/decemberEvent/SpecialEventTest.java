package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialEventTest {

    static SpecialEvent specialEvent;

    @BeforeEach
    void setup() {
        this.specialEvent = new SpecialEvent();
    }

    @DisplayName("특별이벤트 기간인 경우에만 True")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void eventCheckerSpecialEventTrue(int dayTest) {
        Customer newCustomer = new Customer(dayTest);
        assertThat(specialEvent.conditionChecker(newCustomer)).isTrue();
        assertThat(specialEvent.getBenefit(newCustomer)).isEqualTo(1000);
    }

    @DisplayName("특별이벤트 기간이 아닌 경우에만 False")
    @ParameterizedTest
    @ValueSource(ints = {4, 11, 18, 26, 27, 30})
    void eventCheckerSpecialEventFalse(int dayTest) {
        Customer newCustomer = new Customer(dayTest);
        assertThat(specialEvent.conditionChecker(newCustomer)).isFalse();
        assertThat(specialEvent.getBenefit(newCustomer)).isEqualTo(0);
    }

}