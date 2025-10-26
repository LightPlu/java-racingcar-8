package racingcar.view;

import java.util.List;
import racingcar.RacingCar;

public class UserOutputView {

    public void showLevelResult(List<RacingCar> racingCars) {
        String roundResult = ViewParser.parseRoundResult(racingCars);
        System.out.println();
    }

    public void showFinalWinner(List<RacingCar> racingCars) {
        System.out.println("최종 우승자 : " + ViewParser.parseFinalWinner(racingCars));
    }

}
