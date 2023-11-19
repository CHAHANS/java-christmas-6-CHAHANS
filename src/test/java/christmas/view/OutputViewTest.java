package christmas.view;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.service.DecemberEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class OutputViewTest {

    private OutputView outputView;
    private Customer customer;
    private Bills bills;
    private DecemberEventService decemberEventService;
    private OutputStream captor;
    private static final String LINE_SEPARATOR = System.lineSeparator();

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
        this.captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @DisplayName("혜택 미리보기 안내 메세지")
    @Test
    void printSummeryStarter() {
        outputView.printSummeryStarter(customer);
        assertThat(captor.toString().trim()).contains("12월 3일에 우테코 식당에서 받을");
    }

    @DisplayName("주문 메뉴")
    @Test
    void printOrderAll() {
        outputView.printOrderAll(customer);
        assertThat(captor.toString().trim()).contains(
                "<주문 메뉴>",
                "티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개"
        );
    }

    @DisplayName("할인 전 주문 합계")
    @Test
    void printPayBeforeBenefit() {
        outputView.printPayBeforeBenefit(customer);
        assertThat(captor.toString().trim()).contains(
                "<할인 전 총주문 금액>" + LINE_SEPARATOR
                        + "142,000원"
        );
    }

    @DisplayName("증정 메뉴")
    @Test
    void printGiveEventProduct() {
        outputView.printGiveEventProduct(bills);
        assertThat(captor.toString().trim()).contains(
                "<증정 메뉴>" + LINE_SEPARATOR
                        + "샴페인 1개"
        );
    }

    @DisplayName("혜택 내역 전체")
    @Test
    void printBenefitALL() {
        outputView.printBenefitALL(bills);
        assertThat(captor.toString().trim()).contains(
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
                );
    }

    @DisplayName("혜택 받은 금액")
    @Test
    void printTotalBenefitSum() {
        outputView.printTotalBenefitSum(bills);
        assertThat(captor.toString().trim()).contains(
                "<총혜택 금액>" + LINE_SEPARATOR
                        + "-31,246원"
        );
    }

    @DisplayName("할인 후 결제 금액")
    @Test
    void printPayAfterBenefit() {
        outputView.printPayAfterBenefit(bills, customer);
        assertThat(captor.toString().trim()).contains(
                "<할인 후 예상 결제 금액>" + LINE_SEPARATOR
                        + "135,754원"
        );
    }

    @DisplayName("이벤트 뱃지")
    @Test
    void printDecemberBadge() {
        outputView.printDecemberBadge(bills);
        assertThat(captor.toString().trim()).contains(
                "<12월 이벤트 배지>" + LINE_SEPARATOR
                        + "산타"
        );

    }
}