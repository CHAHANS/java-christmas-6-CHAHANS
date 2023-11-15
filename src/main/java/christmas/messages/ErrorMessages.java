package christmas.messages;

public enum ErrorMessages {
    RETRY_INPUT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    RETRY_INPUT_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}