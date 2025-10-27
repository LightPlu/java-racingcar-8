package racingcar.domain.value;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundCountTest {

    @Test
    @DisplayName("음수 입력은 예외가 발생한다")
    void throwExceptionWhenInputNegative() {
        String input = "-1";

        assertThatThrownBy(() -> new RoundCount(input))
                .hasMessageContaining("시도할 횟수에는 음수가 올 수 없습니다.");
    }

    @Test
    @DisplayName("정수가 아닌 입력은 예외가 발생한다")
    void throwExceptionWhenFloatValue() {
        String input = "1.5";

        assertThatThrownBy(() -> new RoundCount(input))
                .hasMessageContaining("시도할 횟수를 정수로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1", " 3 ", "4 "})
    @DisplayName("입력값에 공백이 있다면 예외가 발생한다")
    void throwExceptionWhenBlank(String roundCount) {

        assertThatThrownBy(() -> new RoundCount(roundCount))
                .hasMessageContaining("횟수 앞 뒤로 공백이 올 수 없습니다.");
    }
}
