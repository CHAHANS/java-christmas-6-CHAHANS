package christmas;

import christmas.domain.Bills;
import christmas.domain.Customer;
import christmas.service.DecemberEventService;
import christmas.service.OrderService;

import static christmas.messages.InputGuideMessage.START_HELLO;

public class ChristmasController {
    private final OrderService orderService;
    private final DecemberEventService decemberEventService;

    ChristmasController() {
        this.orderService = new OrderService();
        this.decemberEventService = new DecemberEventService();
    }

    public void mainRun() {
        System.out.println(START_HELLO.getMessage());

        //고객생성
        Customer readyCustomer = orderService.readyCustomer();
        Customer newCustomer = orderService.addCustomerOrder(readyCustomer);

        //Bills 생성
        Bills bills = decemberEventService.getNewBills(newCustomer);
        
        //혜택 미리보기
        decemberEventService.printBills(newCustomer, bills);
    }
}
