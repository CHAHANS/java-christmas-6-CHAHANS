package christmas.service;

import christmas.domain.Bills;
import christmas.domain.Customer;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DecemberEventServiceTest {
    @Test
    void 중간점검용임시테스트() {
        Customer newCustomer = new Customer(3);
        newCustomer.addOrder("티본스테이크", 1);
        newCustomer.addOrder("바비큐립", 1);
        newCustomer.addOrder("초코케이크", 2);
        newCustomer.addOrder("제로콜라", 1);

        DecemberEventService testDES = new DecemberEventService();
        Bills nowBills = testDES.getNewBills(newCustomer);

        assertThat(nowBills.getApprovedEvent())
                .isNotEmpty()
                .containsAllEntriesOf(
                        Map.of("크리스마스 디데이 할인", 1200,
                                "평일 할인", 4046,
                                "특별 할인", 1000,
                                "증정 이벤트", 25000)
                );
    }
}