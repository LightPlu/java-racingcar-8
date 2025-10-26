package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.RacingCar;

public class ViewParser {

    public static String parseCarProgress(RacingCar car) {
        String progress = "-".repeat(car.getPosition());

        return car.getName() + " : " + progress;
    }

    public static String parseRoundResult(List<RacingCar> car) {

        return car.stream()
                .map(ViewParser::parseCarProgress)
                .collect(Collectors.joining("\n"));
    }

    public static String parseFinalWinner(List<RacingCar> winningCars) {

        return winningCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }

    public static List<String> parseCarNames(String carsName) {
        return Arrays.stream(carsName.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
