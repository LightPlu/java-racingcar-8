package racingcar.view;

import java.util.List;
import racingcar.domain.car.RacingCar;

public class UserOutputView {

    public void showRoundResult(List<RacingCar> racingCars) {
        String roundResult = ViewParser.parseRoundResult(racingCars);
        System.out.println(roundResult);
        System.out.println();
    }

    public void showFinalWinner(List<RacingCar> racingCars) {
        System.out.println("최종 우승자 : " + ViewParser.parseFinalWinner(racingCars));
    }

    public void showResultMessage() {
        System.out.println("실행 결과");
    }

}
