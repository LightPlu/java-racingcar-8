package racingcar.domain.service;

import java.util.List;
import racingcar.domain.car.RacingCar;

public class RacingCarFactory {

    public List<RacingCar> createCars(List<String> carsName) {

        return carsName.stream().map(RacingCar::new).toList();
    }

}
