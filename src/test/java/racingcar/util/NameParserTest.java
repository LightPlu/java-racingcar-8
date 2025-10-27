package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameParserTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 파싱한다")
    void parseCarNames() {
        // given
        String input = "pobi,crong,honux";

        // when
        List<String> result = NameParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("단일 자동차 이름을 파싱한다")
    void parseSingleCarName() {
        // given
        String input = "pobi";

        // when
        List<String> result = NameParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("pobi");
    }


}
