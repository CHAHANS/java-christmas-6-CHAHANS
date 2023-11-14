package christmas.domain.decemberEvent;

import christmas.domain.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpecialEvent extends Events {
    private final String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<LocalDate> conditionDay;

    public SpecialEvent() {
        this.eventName = DecemberEvent.SPECIAL_EVENT.getKoreanName();
        this.initBenefits = DecemberEvent.SPECIAL_EVENT.getInitBenefit();
        this.startDate = DecemberEvent.SPECIAL_EVENT.getStartDate();
        this.endDate = DecemberEvent.SPECIAL_EVENT.getEndDate();
        this.conditionDay = new ArrayList<>();
        setConditionDay();
    }

    private void setConditionDay() {
        for (SpecialEvenDayEnum event : SpecialEvenDayEnum.values()) {
            conditionDay.add(event.getEventDay());
        }
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        boolean conditionState = false;
        for (LocalDate eventDay : conditionDay) {
            if (eventDay.getDayOfMonth()
                    == customer.getOrderDate().getDayOfMonth()) {
                conditionState = true;
            }
        }
        return conditionState;
    }

    @Override
    public int getBenefit(Customer customer) {
        if (conditionChecker(customer)) {
            return initBenefits;
        }
        return 0;
    }

    @Override
    public String getEventName() {
        return eventName;
    }
}
