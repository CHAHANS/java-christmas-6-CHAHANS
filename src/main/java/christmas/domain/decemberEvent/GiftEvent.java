package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.EventMenu;

import java.time.LocalDate;

public class GiftEvent extends Events{
    private final String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final EventMenu giftProduct;

    public GiftEvent() {
        this.eventName = DecemberEvent.GIFT_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.GIFT_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.GIFT_EVENT.getStartDate();
        this.endDate = DecemberEvent.GIFT_EVENT.getEndDate();
        this.giftProduct = EventMenu.샴페인;
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        return customer.getTotalProductPrice() >= 120000;
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

    public String getEventName() {
        return eventName;
    }
}
