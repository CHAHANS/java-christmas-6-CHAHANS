package christmas.domain;

import christmas.domain.decemberEvent.BadgeEvent;
import christmas.domain.decemberEvent.Badges;

import java.util.HashMap;
import java.util.Map;

public class Bills {
    private Map<String, Integer> approvedEvent;
    private int totalBenefit;
    private Badges badges;

    public Bills() {
        this.approvedEvent = new HashMap<>();
    }

    public void setApprovedEvent(Map<String, Integer> approvedEvent) {
        this.approvedEvent = approvedEvent;
    }

    public Map<String, Integer> getApprovedEvent() {
        return approvedEvent;
    }

    public void setTotalBenefit() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : approvedEvent.entrySet()) {
            total += entry.getValue();
        }
        totalBenefit = total;
    }

    public void setBadges() {
        BadgeEvent badgeEvent = new BadgeEvent();
        this.badges = badgeEvent.getBadges(totalBenefit);
    }

    public int getTotalBenefit() {
        return totalBenefit;
    }

    public Badges getBadges() {
        return badges;
    }
}
