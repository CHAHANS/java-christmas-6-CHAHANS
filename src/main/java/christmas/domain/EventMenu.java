package christmas.domain;

public enum EventMenu {
    양송이스프(6000, "에피타이저"),
    타파스(5500, "에피타이저"),
    시저샐러드(8000, "에피타이저"),
    티본스테이크(55000, "메인"),
    바비큐립(54000, "메인"),
    해산물파스타(35000, "메인"),
    크리스마스파스타(25000, "메인"),
    초코케이크(15000, "디저트"),
    아이스크림(5000, "디저트"),
    제로콜라(3000, "음료"),
    레드와인(60000, "음료"),
    샴페인(25000, "음료");

    private final int price;
    private final String menuType;

    EventMenu(int price, String menuType) {
        this.price = price;
        this.menuType = menuType;
    }

}
