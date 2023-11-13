package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.Order;

import java.time.LocalDate;

public class WeekDayEvent extends Events {
    private String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;

    WeekDayEvent() {
        this.eventName = DecemberEvent.WEEKDAY_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.WEEKDAY_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.WEEKDAY_EVENT.getStartDate();
        this.endDate = DecemberEvent.WEEKDAY_EVENT.getEndDate();
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        int dayValue = customer.getOrderDate().getDayOfWeek().getValue();
        return 0 < dayValue && dayValue <= 5;
    }

    @Override
    public int getBenefit(Customer customer) {
        int countDesertProduct = 0;
        for (Order thisOrder : customer.getMyOrder()) {
            if (thisOrder.getOrderMenu().getMenuType()=="디저트") {
                countDesertProduct++;
            }
        }
        return initBenefits*countDesertProduct;
    }
}
