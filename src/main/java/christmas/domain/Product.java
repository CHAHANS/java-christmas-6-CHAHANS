package christmas.domain;

public class Product {
    private final String name;
    private final int price;
    private final String type;

    public Product(String name) {
        validateProductName(name);
        EventMenu thisProduct = EventMenu.valueOf(name);
        this.name = thisProduct.getName();
        this.price = thisProduct.getPrice();
        this.type = thisProduct.getMenuType();
    }

    private void validateProductName(String name) {
        for (EventMenu productName : EventMenu.values()) {
            if (productName.getName().equals(name)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getMenuType() {
        return this.type;
    }
}
