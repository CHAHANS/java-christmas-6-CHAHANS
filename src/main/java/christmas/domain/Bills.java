package christmas.domain;

import christmas.domain.decemberEvent.Events;

import java.util.HashMap;
import java.util.Map;

public class Bills {
    private Map<String, Integer> approvedEvent;

    public Bills() {
        this.approvedEvent = new HashMap<>();
    }

    public void setApprovedEvent(Map<String, Integer> approvedEvent) {
        this.approvedEvent = approvedEvent;
    }

    public Map<String, Integer> getApprovedEvent() {
        return approvedEvent;
    }
}
