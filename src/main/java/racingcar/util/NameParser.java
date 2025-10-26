package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    public static List<String> parseCarNames(String carsName) {
        validateInput(carsName);

        return Arrays.stream(carsName.split(","))
                .toList();
    }

    private static void validateInput(String input) {
        validateEmpty(input);
        validateEndPoint(input);
        validateTrim(input);
        validateNameLength(input);
        validateSplitNameIsEmpty(input);
    }

    private static void validateNameLength(String input) {
        List<String> names = nameSplit(input);
        names.forEach(name -> {
            if (name.length() >= 6) {
               throw new IllegalArgumentException("자동차의 이름은 1글자 이상 6글자 미만이어야 합니다.");
            }
        });
    }

    private static void validateSplitNameIsEmpty(String input) {
        List<String> names = nameSplit(input);
        names.forEach(name -> {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(",(comma)사이에 자동차 이름을 입력해주세요.");
            }
        });
    }

    private static void validateTrim(String input) {
        List<String> names = nameSplit(input);
        names.forEach(name -> {
            System.out.println(name);
            System.out.println(name.length());
            if(name.startsWith(" ") || name.endsWith(" ")) {
                throw new IllegalArgumentException("자동차 이름 앞 뒤에는 공백이 올 수 없습니다.");
            }
        });
    }

    private static void validateEmpty(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private static void validateEndPoint(String input) {
        if(input.endsWith(",")) {
            throw new IllegalArgumentException("입력값의 끝은 ,(comma)가 올 수 없습니다.");
        }
    }

    private static List<String> nameSplit(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }
}
