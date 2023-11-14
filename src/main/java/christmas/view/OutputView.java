package christmas.view;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.domain.EventMenu;
import christmas.domain.Order;
import christmas.domain.decemberEvent.DecemberEvent;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Map;

public class OutputView {
    private final DecimalFormat priceFormat;

    public OutputView() {
        this.priceFormat = new DecimalFormat("#,###");
    }

    public void printSummeryStarter(Customer customer) {
        LocalDate date = customer.getOrderDate();
        System.out.println(date.getMonthValue() + "월 " + date.getDayOfMonth() +
                "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrderAll(Customer customer) {
        System.out.println("<주문 메뉴>");
        for (Order order : customer.getMyOrder()) {
            System.out.println(order.getOrderMenu().getName() + " " + order.getEA() + "개");
        }
        System.out.println();
    }

    public void printPayBeforeBenefit(Customer customer) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(priceFormatChanger(customer.getTotalProductPrice()) + "원");
        System.out.println();
    }

    public void printGiveEventProduct(Bills bills) {
        System.out.println("<증정 메뉴>");
        Integer values = bills.getApprovedEvent().get(DecemberEvent.GIFT_EVENT.getKoreanName());
        if (values == null) {
            System.out.println("없음");
        } else {
            System.out.println(EventMenu.샴페인 + " " + "1개");
        }
        System.out.println();
    }

    public void printBenefitALL(Bills bills) {
        System.out.println("<혜택 내역>");
        if (bills.getTotalBenefit() == 0) {
            System.out.println("없음");
        } else {
            for (Map.Entry<String, Integer> event : bills.getApprovedEvent().entrySet()) {
                String value = priceFormatChanger(Math.negateExact(event.getValue()));
                System.out.println(event.getKey() + ": " + value + "원");
            }
        }
        System.out.println();
    }

    public void printTotalBenefitSum(Bills bills) {
        System.out.println("<총혜택 금액>");
        int value = bills.getTotalBenefit();
        if (value == 0) {
            System.out.println("없음");
        } else {
            System.out.println(priceFormatChanger(Math.negateExact(value)) + "원");
        }
        System.out.println();
    }

    public void printPayAfterBenefit(Bills bills, Customer customer) {
        System.out.println("<할인 후 예상 결제 금액>");
        int value = customer.getTotalProductPrice() - bills.getTotalBenefit();
        System.out.println(priceFormatChanger(value) + "원");
        System.out.println();
    }

    public void printDecemberBadge(Bills bills) {
        System.out.println("<12월 이벤트 배지>");
        if (bills.getBadges() == null) {
            System.out.println("없음");
        } else {
            System.out.println(bills.getBadges().getKoreanBadgeName());
        }
    }

    private String priceFormatChanger(int value) {
        return priceFormat.format(value);
    }
}
