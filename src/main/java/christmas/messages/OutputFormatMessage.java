package christmas.messages;

public enum OutputFormatMessage {
    PRICE_FORMAT("#,###"),
    WON("원"),
    EA("개"),
    SPACES(" "),
    LINE_SEPARATOR(System.lineSeparator()),
    NOTTING("없음");

    private String message;

    OutputFormatMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
