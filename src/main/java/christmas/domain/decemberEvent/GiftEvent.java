package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.EventMenu;
import christmas.domain.Order;
import christmas.domain.Product;

import java.time.LocalDate;

public class GiftEvent extends Events{
    private String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final EventMenu giftProduct;

    GiftEvent() {
        this.eventName = DecemberEvent.GIFT_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.GIFT_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.GIFT_EVENT.getStartDate();
        this.endDate = DecemberEvent.GIFT_EVENT.getEndDate();
        this.giftProduct = EventMenu.샴페인;
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        int totalProductPrice = 0;
        for (Order thisOrder : customer.getMyOrder()) {
            totalProductPrice += thisOrder.getOrderPrice();
        }
        return totalProductPrice >= 120000;
    }

    @Override
    public int getBenefit(Customer customer) {
        if (conditionChecker(customer)) {
            return giftProduct.getPrice();
        }
        return 0;
    }

    public EventMenu getGiftProduct() {
        return giftProduct;
    }
}
