package christmas.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;

class InputViewTest {
    static InputView inputView;

    @BeforeEach
    void setup() {
        this.inputView = new InputView();
    }
    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void test1(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(inputView.readDate()).isEqualTo(0);
    }

}