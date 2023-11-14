package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BillsTest {

    @DisplayName("총혜택 금액 계산 테스트")
    @Test
    void totalBenefitTest() {
        Bills bills = new Bills();
        bills.setApprovedEvent(Map.of("크리스마스 디데이 할인", 1200,
                "평일 할인", 4046,
                "특별 할인", 1000,
                "증정 이벤트", 25000));
        bills.setTotalBenefit();
        assertThat(bills.getTotalBenefit())
                .isEqualTo(31246);
    }
}