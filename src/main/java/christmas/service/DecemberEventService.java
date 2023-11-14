package christmas.service;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.domain.EventManager;
import christmas.view.OutputView;

public class DecemberEventService {
    private EventManager eventManager;
    private OutputView outputView;

    public DecemberEventService() {
        this.eventManager = new EventManager();
        this.outputView = new OutputView();
    }

    public Bills getNewBills(Customer customer) {
        if (!eventManager.defaultEventConditionChecker(customer)) {
            return new Bills();
        } else {
            Bills approvedEventBill = new Bills();
            approvedEventBill.setApprovedEvent(eventManager.allEventChecker(customer));
            return approvedEventBill;
        }
    }
}
