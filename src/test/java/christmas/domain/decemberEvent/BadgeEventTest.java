package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeEventTest {
    static BadgeEvent badgeEvent;

    @BeforeEach
    void setup() {
        this.badgeEvent = new BadgeEvent();
    }

    @DisplayName("이벤트 기간인 테스트")
    @Test
    void eventCheckerBadgeEventTrue() {
        Customer newCustomer = new Customer(1);
        assertThat(badgeEvent.conditionChecker(newCustomer)).isTrue();
    }

    @DisplayName("혜택금액에 따른 badges 리턴 경계값 테스트")
    @Test
    void returnBadgesBoundaryValueTEST() {
        Customer newCustomer = new Customer(25);
        assertThat(badgeEvent.getBenefit(newCustomer))
                .isEqualTo(0);
        //santa >= 20000
        assertThat(badgeEvent.getBadges(21000))
                .isEqualTo(Badges.SANTA);
        assertThat(badgeEvent.getBadges(20000))
                .isEqualTo(Badges.SANTA);
        //tree >= 10000
        assertThat(badgeEvent.getBadges(19000))
                .isEqualTo(Badges.TREE);
        assertThat(badgeEvent.getBadges(10000))
                .isEqualTo(Badges.TREE);
        //star >= 5000
        assertThat(badgeEvent.getBadges(9000))
                .isEqualTo(Badges.STAR);
        assertThat(badgeEvent.getBadges(5000))
                .isEqualTo(Badges.STAR);
        //null < 5000
        assertThat(badgeEvent.getBadges(4900))
                .isEqualTo(null);
        assertThat(badgeEvent.getBadges(0))
                .isEqualTo(null);

    }

}