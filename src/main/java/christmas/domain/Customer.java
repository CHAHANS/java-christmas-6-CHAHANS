package christmas.domain;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Order> myOrder;
    private final LocalDate orderDate;

    public Customer(int date) {
        this.myOrder = new ArrayList<>();
        this.orderDate = validateOrderDate(date);
    }

    public boolean addOrder(String order, int EA) {
        for (Order beforOrder : myOrder) {
            if (beforOrder.getOrderMenu().compareToProduct(order)) {
                return false;
            }
        }
        myOrder.add(new Order(order, EA));
        return true;
    }

    public boolean checkOnlyDrinkOrder() {
        for (Order nowOrder : myOrder) {
            if (nowOrder.getOrderMenu().getMenuType() != "음료") {
                return false;
            }
        }
        return true;
    }

    private LocalDate validateOrderDate(int date) {
        try {
            return LocalDate.of(2023, 12, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Order> getMyOrder() {
        return myOrder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

}
