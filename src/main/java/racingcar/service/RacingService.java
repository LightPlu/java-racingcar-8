package racingcar.service;

import java.util.List;
import racingcar.domain.car.RacingCar;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.service.FindMaxPositionCars;
import racingcar.domain.service.RacingCarFactory;

public class RacingService {

    private final MovePolicy movePolicy;
    private final FindMaxPositionCars findMaxPositionCars;
    private final RacingCarFactory racingCarFactory;

    public RacingService(MovePolicy movePolicy,
                             FindMaxPositionCars findMaxPositionCars,
                             RacingCarFactory racingCarFactory) {
        this.movePolicy = movePolicy;
        this.findMaxPositionCars = findMaxPositionCars;
        this.racingCarFactory = racingCarFactory;
    }

    public List<RacingCar> createRacingCars(List<String> carsName) {
        return racingCarFactory.createCars(carsName);
    }

    public void playRounds(List<RacingCar> racingCars) {
        racingCars.forEach(car -> car.move(movePolicy.carMoveCondition()));
    }

    public List<RacingCar> findWinners(List<RacingCar> racingCars) {
        int maxPosition = findMaxPositionCars.findMaxPosition(racingCars);
        return findMaxPositionCars.findMaxPositionCars(racingCars, maxPosition);
    }
}
