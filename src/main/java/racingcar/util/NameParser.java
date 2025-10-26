package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    public static List<String> parseCarNames(String carsName) {

        return Arrays.stream(carsName.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
