package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import christmas.domain.EventMenu;
import christmas.domain.Order;

import java.time.LocalDate;

public class WeekEndEvent extends Events {
    private String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;

    WeekEndEvent() {
        this.eventName = DecemberEvent.WEEKEND_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.WEEKEND_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.WEEKEND_EVENT.getStartDate();
        this.endDate = DecemberEvent.WEEKEND_EVENT.getEndDate();
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
        return 5 < dayValue && dayValue <= 7;
    }

    private int isEqualsProductCount(Customer customer) {
        int countProduct = 0;
        for (Order thisOrder : customer.getMyOrder()) {
            if (thisOrder.getOrderMenu().getMenuType() == "메인") {
                countProduct += thisOrder.getEA();
            }
        }
        return countProduct;
    }
}
