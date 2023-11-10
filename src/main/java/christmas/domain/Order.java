package christmas.domain;

public class Order {
    private final Product orderMenu;
    private final int EA;
    private final int orderPrice;

    Order(String orderedProduct, int EA) {
        this.orderMenu = new Product(orderedProduct);
        validateEA(EA);
        this.EA = EA;
        this.orderPrice = orderMenu.getPrice() * EA;
    }

    private void validateEA(int EA) {
        if (EA > 20) {
            throw new IllegalArgumentException();
        }
    }

    public Product getOrderMenu() {
        return orderMenu;
    }

    public int getEA() {
        return EA;
    }

    public int getOrderPrice() {
        return orderPrice;
    }
}
