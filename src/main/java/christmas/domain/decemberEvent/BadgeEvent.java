package christmas.domain.decemberEvent;

import christmas.domain.Customer;
import static christmas.domain.decemberEvent.Badges.*;

import java.time.LocalDate;

public class BadgeEvent extends Events{
    private final String eventName;
    private final int initBenefits;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public BadgeEvent() {
        this.eventName = DecemberEvent.BADGE_EVENT.name();
        this.initBenefits = DecemberEvent.BADGE_EVENT.getInitBenefit();
        this.startDate= DecemberEvent.BADGE_EVENT.getStartDate();
        this.endDate= DecemberEvent.BADGE_EVENT.getEndDate();
    }

    @Override
    public boolean conditionChecker(Customer customer) {
        return false;
    }

    @Override
    public int getBenefit(Customer customer) {
        return 0;
    }

    public Badges getBadges(int benefit) {
        if (benefit>=SANTA.getBenefitCondition()) {
            return SANTA;
        }
        else if (benefit>=TREE.getBenefitCondition()) {
            return TREE;
        }
        else if (benefit>=STAR.getBenefitCondition()) {
            return STAR;
        }
        return null;
    }

    public String getEventName() {
        return eventName;
    }
}
