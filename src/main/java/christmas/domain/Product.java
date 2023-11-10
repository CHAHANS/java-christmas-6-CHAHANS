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
            if (productName.name().equals(name)){
                break;
            }
        }
        throw new IllegalArgumentException();
    }
}
