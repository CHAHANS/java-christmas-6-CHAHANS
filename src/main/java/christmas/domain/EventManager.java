package christmas.domain;

import christmas.domain.decemberEvent.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private List<Events> nowDoingEvent;
    private BadgeEvent bonusEvent;

    public EventManager() {
        this.nowDoingEvent = new ArrayList<>();
        setNowEvents();
    }

    private void setNowEvents() {
        this.nowDoingEvent.add(new CrismasDdayEvent());
        this.nowDoingEvent.add(new WeekDayEvent());
        this.nowDoingEvent.add(new WeekEndEvent());
        this.nowDoingEvent.add(new SpecialEvent());
        this.nowDoingEvent.add(new GiftEvent());
        this.bonusEvent = new BadgeEvent();
    }

    public boolean defaultEventConditionChecker(Customer customer) {
        return customer.getTotalProductPrice() >= 10000;
    }

    public Map<String, Integer> allEventChecker(Customer customer) {
        Map<String, Integer> approvedEvent = new HashMap<>();
        for (Events thisEvent : nowDoingEvent) {
            if (thisEvent.conditionChecker(customer)) {
                approvedEvent.put(thisEvent.getEventName(), thisEvent.getBenefit(customer));
            }
        }
        return approvedEvent;
    }

    public Badges getBonusBadges(Bills bills) {
        return bonusEvent.getBadges(bills.getTotalBenefit());
    }

    public List<Events> getNowDoingEvent() {
        nowDoingEvent.add(bonusEvent);
        return nowDoingEvent;
    }
}
