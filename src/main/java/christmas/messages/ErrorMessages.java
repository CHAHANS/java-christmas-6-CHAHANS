package christmas.messages;

public enum ErrorMessages {
    RETRY_INPUT_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    RETRY_INPUT_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    FAIL_VALID_DATE("[ERROR] 없는 날짜입니다."),
    FAIL_PARSE_INTEGER("[ERROR] 숫자만 입력해주세요");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
