package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine().trim();
        return validateNumberInput(input);
    }

    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine().trim();
        return input;
    }

    public int validateNumberInput(String input) {
        return Integer.parseInt(input);
    }

    public String[] validateSplitEachOrder(String input) {
        return input.split(","); //주문메뉴 구분
    }

    public String[] validateSplitEachMenu(String input) {
        return input.split("-");
    }
}
