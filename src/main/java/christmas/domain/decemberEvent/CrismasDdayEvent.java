package christmas.domain.decemberEvent;

import christmas.domain.Customer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrismasDdayEvent extends Events{
    private String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public CrismasDdayEvent() {
        this.eventName = DecemberEvent.D_DAY_EVENT.name();
        this.initBenefits = DecemberEvent.D_DAY_EVENT.getInitBenefit();
        this.startDate= DecemberEvent.D_DAY_EVENT.getStartDate();
        this.endDate= DecemberEvent.D_DAY_EVENT.getEndDate();
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        LocalDate customerDate = customer.getOrderDate();
        return !customerDate.isBefore(startDate) && !customerDate.isAfter(endDate);
    }

    @Override
    public int getBenefit(Customer customer) {
        if (conditionChecker(customer)) {
            int bonusDay = (int) ChronoUnit.DAYS.between(startDate, customer.getOrderDate());
            int bonus = 100;
            return initBenefits + (100 * bonusDay);
        }
        return 0;
    }
}
