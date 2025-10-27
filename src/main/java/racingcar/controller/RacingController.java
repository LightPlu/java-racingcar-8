package racingcar.controller;

import java.util.List;
import racingcar.domain.car.RacingCar;
import racingcar.domain.value.RoundCount;
import racingcar.service.RacingService;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class RacingController {

    private final UserInputView userInputView = new UserInputView();
    private final UserOutputView userOutputView = new UserOutputView();
    private final RacingService racingService = new RacingService();

    public void run() {
        String carsName = getCarsNameFromUser();
        RoundCount totalRound = getRoundCountFromUser();

        List<RacingCar> cars = racingService.createRacingCars(carsName);

        userOutputView.showResultMessage();
        playGame(cars, totalRound);

        List<RacingCar> winners = racingService.findWinners(cars);
        userOutputView.showFinalWinner(winners);
    }

    private String getCarsNameFromUser() {
        userInputView.getCarsNameMessage();
        return userInputView.getInput();
    }

    private RoundCount getRoundCountFromUser() {
        userInputView.getAttemptNumberMessage();
        return new RoundCount(userInputView.getInput());
    }

    private void playGame(List<RacingCar> cars, RoundCount totalRound) {
        for (int round = 0; round < totalRound.getRoundCount(); round++) {
            racingService.playRounds(cars);
            userOutputView.showRoundResult(cars);
        }
    }
}
