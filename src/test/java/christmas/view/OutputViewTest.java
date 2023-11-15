package christmas.view;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.service.DecemberEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputView outputView;
    private Customer customer;
    private Bills bills;
    private DecemberEventService decemberEventService;

    @BeforeEach
    void setup() {
        this.outputView = new OutputView();
        this.customer = new Customer(3);
        customer.addOrder("티본스테이크", 1);
        customer.addOrder("바비큐립", 1);
        customer.addOrder("초코케이크", 2);
        customer.addOrder("제로콜라", 1);
        this.decemberEventService = new DecemberEventService();
        this.bills = decemberEventService.getNewBills(customer);
    }

    @DisplayName("혜택 미리보기 안내 메세지")
    @Test
    void printSummeryStarter() {
        outputView.printSummeryStarter(customer);
    }

    @DisplayName("주문 메뉴")
    @Test
    void printOrderAll() {
        outputView.printOrderAll(customer);
    }

    @DisplayName("할인 전 주문 합계")
    @Test
    void printPayBeforeBenefit() {
        outputView.printPayBeforeBenefit(customer);
    }

    @DisplayName("증정 메뉴")
    @Test
    void printGiveEventProduct() {
        outputView.printGiveEventProduct(bills);
    }

    @DisplayName("혜택 내역 전체")
    @Test
    void printBenefitALL() {
        outputView.printBenefitALL(bills);
    }

    @DisplayName("혜택 받은 금액")
    @Test
    void printTotalBenefitSum() {
        outputView.printTotalBenefitSum(bills);
    }

    @DisplayName("할인 후 결제 금액")
    @Test
    void printPayAfterBenefit() {
        outputView.printPayAfterBenefit(bills, customer);
    }

    @DisplayName("이벤트 뱃지")
    @Test
    void printDecemberBadge() {
        outputView.printDecemberBadge(bills);
    }
}