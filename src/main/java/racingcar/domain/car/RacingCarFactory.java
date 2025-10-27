package racingcar.domain.car;

import java.util.List;

public class RacingCarFactory {

    public List<RacingCar> createCars(List<String> carsName) {

        return carsName.stream().map(RacingCar::new).toList();
    }

}
