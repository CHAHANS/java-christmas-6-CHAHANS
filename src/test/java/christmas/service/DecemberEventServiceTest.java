package christmas.service;

import christmas.domain.Bills;
import christmas.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DecemberEventServiceTest {
    DecemberEventService decemberEventService;
    Customer customer;
    Bills bills;
    @BeforeEach
    void setup() {
        this.decemberEventService = new DecemberEventService();
        this.customer = new Customer(3);
        customer.addOrder("티본스테이크", 1);
        customer.addOrder("바비큐립", 1);
        customer.addOrder("초코케이크", 2);
        customer.addOrder("제로콜라", 1);
        this.bills = decemberEventService.getNewBills(customer);
    }

    @Test
    void 중간점검용임시테스트() {
        assertThat(bills.getApprovedEvent())
                .isNotEmpty()
                .containsAllEntriesOf(
                        Map.of("크리스마스 디데이 할인", 1200,
                                "평일 할인", 4046,
                                "특별 할인", 1000,
                                "증정 이벤트", 25000)
                );
    }

    @Test
    void printAllTest() {
        decemberEventService.printBills(customer, bills);
    }
}