package racingcar.service;

import static racingcar.util.InputValidator.validateInput;

import java.util.List;
import racingcar.domain.car.RacingCar;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.service.FindMaxPositionCars;
import racingcar.domain.car.RacingCarFactory;
import racingcar.util.NameParser;

public class RacingService {

    private final MovePolicy movePolicy = new MovePolicy();
    private final FindMaxPositionCars findMaxPositionCars = new FindMaxPositionCars();
    private final RacingCarFactory racingCarFactory = new RacingCarFactory();

    public List<RacingCar> createRacingCars(String carsName) {
        List<String> parsedNames = NameParser.parseCarNames(validateInput(carsName));
        return racingCarFactory.createCars(parsedNames);
    }

    public void playRounds(List<RacingCar> racingCars) {
        racingCars.forEach(car -> car.move(movePolicy.carMoveCondition()));
    }

    public List<RacingCar> findWinners(List<RacingCar> racingCars) {
        int maxPosition = findMaxPositionCars.findMaxPosition(racingCars);
        return findMaxPositionCars.findMaxPositionCars(racingCars, maxPosition);
    }
}
