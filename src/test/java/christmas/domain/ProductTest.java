package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @DisplayName("이름이 EventMenu 에 없는경우 애러 발생")
    @Test
    void productNameInValidTest() {
        assertThatThrownBy(() -> new Product("샴피"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 정상적인 경우 값을 잘복사했는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"양송이스프", "타파스", "시저샐러드",
            "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
            "초코케이크", "아이스크림",
            "제로콜라", "레드와인", "샴페인"})
    void productNameValidTest(String productName) {
        Product newProduct = new Product(productName);
        assertThat(newProduct.getName()).isEqualTo(EventMenu.valueOf(productName).getName());
        assertThat(newProduct.getPrice()).isEqualTo(EventMenu.valueOf(productName).getPrice());
        assertThat(newProduct.getMenuType()).isEqualTo(EventMenu.valueOf(productName).getMenuType());
    }
}