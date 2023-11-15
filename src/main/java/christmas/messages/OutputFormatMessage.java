package christmas.messages;

public enum OutputFormatMessage {
    SUMMERY_START_MESSAGE("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!%n"),
    ORDER_ALL_TITLE("<주문 메뉴>%n"),
    GIFT_EVENT_PRODUCT_TITLE("<증정 메뉴>%n"),
    PAY_BEFORE_BENEFIT_TITLE("<할인 전 총주문 금액>%n"),
    PAY_AFTER_BENEFIT_TITLE("<할인 후 예상 결제 금액>%n"),
    BENEFIT_ALL_TITLE("<혜택 내역>%n"),
    BENEFIT_SUM_TITLE("<총혜택 금액>%n"),
    DECEMBER_BADGE_TITLE("<12월 이벤트 배지>%n"),
    PRINT_EVENTS_BENEFIT_FORMAT("%s: %,d원%n"),
    PRINT_PRODUCT_EA_FORMAT("%s %d개%n"),
    PRINT_PRICE_KRW_FORMAT("%,d원%n"),
    NOTTING("없음%n");

    private final String message;

    OutputFormatMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
