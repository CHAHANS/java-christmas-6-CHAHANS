package christmas.view;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.domain.Order;
import christmas.domain.decemberEvent.DecemberEvent;

import static christmas.messages.OutputFormatMessage.*;

import java.time.LocalDate;
import java.util.Map;

public class OutputView {

    public void printSummeryStarter(Customer customer) {
        LocalDate date = customer.getOrderDate();
        System.out.printf(SUMMERY_START_MESSAGE.getMessage(), date.getMonthValue(), date.getDayOfMonth());
        System.out.println();
    }

    public void printOrderAll(Customer customer) {
        System.out.printf(ORDER_ALL_TITLE.getMessage());
        for (Order order : customer.getMyOrder()) {
            System.out.printf(PRINT_PRODUCT_EA_FORMAT.getMessage(), order.getOrderMenu().getName(), order.getEA());
        }
        System.out.println();
    }

    public void printPayBeforeBenefit(Customer customer) {
        System.out.printf(PAY_BEFORE_BENEFIT_TITLE.getMessage());
        System.out.printf(PRINT_PRICE_KRW_FORMAT.getMessage(), customer.getTotalProductPrice());
        System.out.println();
    }

    public void printGiveEventProduct(Bills bills) {
        System.out.printf(GIFT_EVENT_PRODUCT_TITLE.getMessage());
        String giftProduct = DecemberEvent.GIFT_EVENT.getKoreanName();
        if (bills.getApprovedEvent().get(giftProduct) == null) {
            System.out.printf(NOTTING.getMessage());
        } else {
            System.out.printf(PRINT_PRODUCT_EA_FORMAT.getMessage(), giftProduct, 1);
        }
        System.out.println();
    }

    public void printBenefitALL(Bills bills) {
        System.out.printf(BENEFIT_ALL_TITLE.getMessage());
        if (bills.getTotalBenefit() <= 0) {
            System.out.printf(NOTTING.getMessage());
        } else {
            for (Map.Entry<String, Integer> event : bills.getApprovedEvent().entrySet()) {
                System.out.printf(PRINT_EVENTS_BENEFIT_FORMAT.getMessage()
                        , event.getKey()
                        , Math.negateExact(event.getValue())
                );
            }
        }
        System.out.println();
    }

    public void printTotalBenefitSum(Bills bills) {
        System.out.printf(BENEFIT_SUM_TITLE.getMessage());
        int benefitSum = bills.getTotalBenefit();
        if (benefitSum <= 0) {
            System.out.printf(NOTTING.getMessage());
        } else {
            System.out.printf(PRINT_PRICE_KRW_FORMAT.getMessage(), Math.negateExact(benefitSum));
        }
        System.out.println();
    }

    public void printPayAfterBenefit(Bills bills, Customer customer) {
        System.out.printf(PAY_AFTER_BENEFIT_TITLE.getMessage());
        int payValue = customer.getTotalProductPrice() - bills.getTotalBenefit();
        System.out.printf(PRINT_PRICE_KRW_FORMAT.getMessage(), payValue);
        System.out.println();
    }

    public void printDecemberBadge(Bills bills) {
        System.out.printf(DECEMBER_BADGE_TITLE.getMessage());
        if (bills.getBadges() == null) {
            System.out.printf(NOTTING.getMessage());
        } else {
            System.out.println(bills.getBadges().getKoreanBadgeName());
        }
        System.out.println();
    }
}
