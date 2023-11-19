package christmas.service;

import christmas.domain.Customer;
import static christmas.messages.ErrorMessages.*;
import christmas.view.InputView;

import java.util.Arrays;
import java.util.Iterator;

public class OrderService {
    private final InputView inputView;

    public OrderService() {
        this.inputView = new InputView();
    }

    public Customer readyCustomer() {
        while (true) {
            try {
                int orderDate = inputView.readDate();
                return new Customer(orderDate);
            } catch (NumberFormatException e) {
                System.out.println(FAIL_PARSE_INTEGER.getMessage());
                System.out.println(RETRY_INPUT_DATE.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(FAIL_VALID_DATE.getMessage());
                System.out.println(RETRY_INPUT_DATE.getMessage());
            }
        }
    }

    public Customer addCustomerOrder(Customer customer) {
        while (true) {
            try {
                String orderProduct = inputView.readOrder();
                return iteratorOrderAdd(customer, orderProduct);
            } catch (IllegalArgumentException e) {
                System.out.println(RETRY_INPUT_ORDER.getMessage());
            }
        }
    }

    private Customer iteratorOrderAdd(Customer customer, String orderProduct){
        Iterator orderIter = Arrays.stream(inputView.validateSplitEachOrder(orderProduct)).iterator();
        while (orderIter.hasNext()) {
            String[] nowOrder = inputView.validateSplitEachMenu((String) orderIter.next());
            String nowOrderProduct = nowOrder[0];
            int nowOrderEA = inputView.validateNumberInput(nowOrder[1]);
            customer.addOrder(nowOrderProduct, nowOrderEA);
        }
        customer.checkOnlyDrinkOrder();
        return customer;
    }
}


