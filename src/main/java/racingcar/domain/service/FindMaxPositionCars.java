package racingcar.domain.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.RacingCar;

public class FindMaxPositionCars {

    List<RacingCar> winningCars = new ArrayList<>();

    public int findMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        return validateMaxPosition(maxPosition);
    }

    public List<RacingCar> findMaxPositionCars(List<RacingCar> racingCars, int maxPosition) {
        racingCars.forEach(racingCar -> {
            if (racingCar.getPosition() == validateMaxPosition(maxPosition)) {
                winningCars.add(racingCar);
            }
        });

        return winningCars;
    }

    public int validateMaxPosition(int maxPosition) {
        if (maxPosition == 0) {
            throw new IllegalArgumentException("아무 자동차도 전진하지 못하여 우승자는 없습니다.");
        }
        return maxPosition;
    }
}
