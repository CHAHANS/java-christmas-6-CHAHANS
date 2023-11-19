package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrismasDdayEventTest {
    static CrismasDdayEvent crismasDdayEvent;

    @BeforeEach
    void setup() {
        this.crismasDdayEvent = new CrismasDdayEvent();
    }

    @DisplayName("이벤트 기간이 아닌날 테스트")
    @Test
    void eventCheckerDdayEventFalse() {
        Customer newCustomer = new Customer(26);
        assertThat(crismasDdayEvent.conditionChecker(newCustomer)).isFalse();
    }

    @DisplayName("이벤트 기간인날 테스트")
    @Test
    void eventCheckerDdayEventTrue() {
        Customer newCustomer = new Customer(25);
        assertThat(crismasDdayEvent.conditionChecker(newCustomer)).isTrue();
    }

    @DisplayName("해택금액 계산 기본1000 + 경과일수*100")
    //메뉴가 없는경우?
    @Test
    void dDayEventGetBenefit() {
        Customer newCustomer = new Customer(25);
        assertThat(crismasDdayEvent.getBenefit(newCustomer))
                .isEqualTo(3400);
    }
}