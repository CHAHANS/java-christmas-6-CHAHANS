package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.EventMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiftEventTest {

    static GiftEvent giftEvent;

    @BeforeEach
    void setup() {
        this.giftEvent = new GiftEvent();
    }

    @DisplayName("총구매금액 12만원 미만 이벤트 조건 미충족 테스트")
    @Test
    void eventCheckerGiftEventFalse() {
        Customer newCustomer = new Customer(29);
        newCustomer.addOrder("티본스테이크", 2);
        assertThat(giftEvent.conditionChecker(newCustomer)).isFalse();
        assertThat(giftEvent.getBenefit(newCustomer)).isEqualTo(0);
    }

    @DisplayName("총구매금액 12만원 이상 이벤트 조건 충족 테스트")
    @Test
    void eventCheckerGiftEvenTrue() {
        Customer newCustomer = new Customer(29);
        newCustomer.addOrder("티본스테이크", 2);
        newCustomer.addOrder("아이스크림", 2);
        assertThat(giftEvent.conditionChecker(newCustomer)).isTrue();
        assertThat(giftEvent.getBenefit(newCustomer)).isEqualTo(EventMenu.샴페인.getPrice());
    }

    @DisplayName("지정된 이벤트 상품인 샴페인 리턴 기능 테스트")
    @Test
    void getGiftEventProductReturnTest() {
        assertThat(giftEvent.getGiftProduct()).isEqualTo(EventMenu.샴페인);
    }
}