package christmas;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.domain.decemberEvent.DecemberEvent;
import christmas.service.DecemberEventService;
import christmas.service.OrderService;

public class ChristmasController {
    private OrderService orderService;
    private DecemberEventService decemberEventService;

    ChristmasController() {
        this.orderService = new OrderService();
        this.decemberEventService = new DecemberEventService();
    }

    public void mainRun() {
        //고객생성
        Customer readyCustomer = orderService.readyCustomer();
        Customer newCustomer = orderService.addCustomerOrder(readyCustomer);

        //Bills 생성
        Bills bills = decemberEventService.getNewBills(newCustomer);
        decemberEventService.printBills(newCustomer, bills);
    }
}
