package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.car.RacingCar;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.service.FindMaxPositionCars;
import racingcar.domain.service.RacingCarFactory;
import racingcar.domain.value.RoundCount;
import racingcar.service.RacingService;
import racingcar.util.NameParser;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class RacingController {

    private final UserInputView userInputView = new UserInputView();
    private final UserOutputView userOutputView = new UserOutputView();
    private final MovePolicy movePolicy = new MovePolicy();
    private final FindMaxPositionCars findMaxPositionCars = new FindMaxPositionCars();
    private final RacingCarFactory racingCarFactory = new RacingCarFactory();
    private final RacingService racingService = new RacingService(movePolicy, findMaxPositionCars, racingCarFactory);


    public void run() {
        userInputView.getCarsNameMessage();
        String carsName = userInputView.getInput();
        List<RacingCar> cars = racingService.createRacingCars(NameParser.parseCarNames(carsName));
        userInputView.getAttemptNumberMessage();
        RoundCount totalRound = new RoundCount(userInputView.getInput());

        userOutputView.showResultMessage();

        IntStream.range(0, totalRound.getRoundCount()).forEach(round -> {
            racingService.playRounds(cars);
            userOutputView.showRoundResult(cars);

        });

        List<RacingCar> winners = racingService.findWinners(cars);

        userOutputView.showFinalWinner(winners);
    }
}
