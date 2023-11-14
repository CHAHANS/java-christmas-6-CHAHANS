package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.Order;

import java.time.LocalDate;

public class WeekDayEvent extends Events {
    private final String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public WeekDayEvent() {
        this.eventName = DecemberEvent.WEEKDAY_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.WEEKDAY_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.WEEKDAY_EVENT.getStartDate();
        this.endDate = DecemberEvent.WEEKDAY_EVENT.getEndDate();
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        return dayConditionChecker(customer) && (isEqualsProductCount(customer) != 0);
    }

    @Override
    public int getBenefit(Customer customer) {
        if (conditionChecker(customer)) {
            return initBenefits * isEqualsProductCount(customer);
        }
        return 0;
    }

    private boolean dayConditionChecker(Customer customer) {
        int dayValue = customer.getOrderDate().getDayOfWeek().getValue();
        return (0 < dayValue && dayValue <= 4) || dayValue == 7;
    }

    private int isEqualsProductCount(Customer customer) {
        int countProduct = 0;
        for (Order thisOrder : customer.getMyOrder()) {
            if ("디저트".equals(thisOrder.getOrderMenu().getMenuType())) {
                countProduct += thisOrder.getEA();
            }
        }
        return countProduct;
    }

    public String getEventName() {
        return eventName;
    }
}
