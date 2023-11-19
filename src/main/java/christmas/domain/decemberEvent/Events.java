package christmas.domain.decemberEvent;

import christmas.domain.Customer;

public abstract class Events {
    abstract public boolean conditionChecker(Customer customer);

    abstract public int getBenefit(Customer customer);
    abstract public String getEventName();
}
