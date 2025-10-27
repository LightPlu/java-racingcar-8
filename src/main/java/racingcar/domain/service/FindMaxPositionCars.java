package racingcar.domain.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.RacingCar;

public class FindMaxPositionCars {

    List<RacingCar> winningCars =  new ArrayList<>();

    public int findMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;

        for(RacingCar racingCar : racingCars) {
            if(racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        return maxPosition;
    }

    public List<RacingCar> findMaxPositionCars(List<RacingCar> racingCars, int maxPosition) {
        racingCars.forEach(racingCar -> {
            if(racingCar.getPosition() == maxPosition) {
                winningCars.add(racingCar);
            }
        });

        return winningCars;
    }
}
