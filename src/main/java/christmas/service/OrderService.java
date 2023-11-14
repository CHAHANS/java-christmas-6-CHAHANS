package christmas.service;

import christmas.domain.Customer;
import christmas.view.InputView;

import java.util.Arrays;
import java.util.Iterator;

public class OrderService {
    static InputView inputView;

    public OrderService() {
        this.inputView = new InputView();
    }

    public Customer readyCustomer() {
        while (true) {
            try {
                int orderDate = inputView.readDate();
                Customer result = new Customer(orderDate);
                result.checkOnlyDrinkOrder();
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public Customer addCustomerOrder(Customer customer) {
        while (true) {
            try {
                String orderProduct = inputView.readOrder();
                Customer addedOrderCustomer = iteratorOrderAdd(customer, orderProduct);
                return customer;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
        return customer;
    }
}


