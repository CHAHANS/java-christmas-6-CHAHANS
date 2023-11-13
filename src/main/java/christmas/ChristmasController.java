package christmas;

import christmas.domain.Customer;
import christmas.service.OrderService;

public class ChristmasController {
    static OrderService orderService;

    ChristmasController() {
        this.orderService = new OrderService();
    }
    public void mainRun() {
        //고객생성
        Customer readyCustomer = orderService.readyCustomer();
        Customer newCustomer = orderService.addCustomerOrder(readyCustomer);
    }
}
