package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("이름 중간에 공백이 있어도 허용된다")
    void parseCarNamesWithMiddleSpace() {
        // given
        String input = "po bi,ar mi";

        // when
        List<String> result = NameParser.parseCarNames(input);

        // then
        assertThat(result).containsExactly("po bi", "ar mi");
    }

    @Test
    @DisplayName("빈 문자열이 입력되면 예외가 발생한다")
    void throwExceptionWhenEmptyInput() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해주세요");
    }

    @Test
    @DisplayName("이름 앞에 공백이 있으면 예외가 발생한다")
    void throwExceptionWhenLeadingSpace() {
        // given
        String input = " pobi,crong";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 올 수 없습니다");
    }

    @Test
    @DisplayName("이름 뒤에 공백이 있으면 예외가 발생한다")
    void throwExceptionWhenTrailingSpace() {
        // given
        String input = "pobi ,crong";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 올 수 없습니다");
    }

    @Test
    @DisplayName("이름 앞뒤에 공백이 모두 있으면 예외가 발생한다")
    void throwExceptionWhenBothSpaces() {
        // given
        String input = " pobi , crong ";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 올 수 없습니다", "1글자 이상 6글자 미만");
    }

    @Test
    @DisplayName("쉼표 사이에 이름이 없으면 예외가 발생한다")
    void throwExceptionWhenEmptyNameBetweenCommas() {
        // given
        String input = "pobi,,crong";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("comma)사이에 자동차 이름을 입력해주세요");
    }

    @Test
    @DisplayName("이름이 6글자 이상이면 예외가 발생한다")
    void throwExceptionWhenNameTooLong() {
        // given
        String input = "pobi,verylongname";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1글자 이상 6글자 미만");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", "pobi12"})
    @DisplayName("6글자 이름도 예외가 발생한다")
    void throwExceptionWhenNameIsSixCharacters(String name) {
        // given
        String input = "pobi," + name;

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1글자 이상 6글자 미만");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("1~5글자 이름은 정상적으로 파싱된다")
    void parseValidLengthNames(String name) {
        // given
        String input = "pobi," + name;

        // when
        List<String> result = NameParser.parseCarNames(input);

        // then
        assertThat(result).contains(name);
    }

    @Test
    @DisplayName("여러 자동차 이름을 정상적으로 파싱한다")
    void parseMultipleCarNames() {
        // given
        String input = "a,bb,ccc,dddd,eeeee";

        // when
        List<String> result = NameParser.parseCarNames(input);

        // then
        assertThat(result)
                .hasSize(5)
                .containsExactly("a", "bb", "ccc", "dddd", "eeeee");
    }

    @Test
    @DisplayName("쉼표로만 구성된 입력은 예외가 발생한다")
    void throwExceptionWhenOnlyCommas() {
        // given
        String input = ",,,";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값의 끝은 ,(comma)가 올 수 없습니다");
    }

    @Test
    @DisplayName("쉼표로 시작하면 예외가 발생한다")
    void throwExceptionWhenStartsWithComma() {
        // given
        String input = ",pobi,crong";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "comma)사이에 자동차 이름을 입력해주세요",
                        "");
    }

    @Test
    @DisplayName("쉼표로 끝나면 예외가 발생한다")
    void throwExceptionWhenEndsWithComma() {
        // given
        String input = "pobi,crong,";

        // when & then
        assertThatThrownBy(() -> NameParser.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(",(comma)가 올 수 없습니다.");
    }
}
