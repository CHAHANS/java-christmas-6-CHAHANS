package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Order> myOrder;
    private final String orderDate;

    public Customer(String date) {
        this.myOrder = new ArrayList<>();
        this.orderDate = date;
    }

    public boolean addOrder(String order, int EA) {
        String beforeOrderName;
        for (Order beforOrder : myOrder) {
            if (beforOrder.getOrderMenu().compareToProduct(order)) {
                return false;
            }
        }
        myOrder.add(new Order(order, EA));
        return true;
    }
}
