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

    public void addOrder(String order, int EA) {
        checkTotalEA(EA);
        checkCompareProduct(order);
        myOrder.add(new Order(order, EA));
    }

    private void checkTotalEA(int EA) {
        int totalEA = 0;
        for (Order beforOrder : myOrder) {
            totalEA += beforOrder.getEA();
        }
        totalEA += EA;
        if (totalEA < 1|| totalEA > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCompareProduct(String order) {
        for (Order beforOrder : myOrder) {
            if (beforOrder.getOrderMenu().compareToProduct(order)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkOnlyDrinkOrder() {
        for (Order nowOrder : myOrder) {
            if ("음료".equals(nowOrder.getOrderMenu().getMenuType())) {
                throw new IllegalArgumentException();
            }
        }
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
