package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import static christmas.messages.InputGuideMessage.*;

public class InputView {
    public int readDate() {
        System.out.println(INPUT_DATE_GUIDE.getMessage());
        String input = Console.readLine().trim();
        return validateNumberInput(input);
    }

    public String readOrder() {
        System.out.println(INPUT_ORDER_GUIDE.getMessage());
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
