package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarFactoryTest {

    private RacingCarFactory racingCarFactory;

    @BeforeEach
    void setUp() {
        racingCarFactory = new RacingCarFactory();
    }

    @Test
    @DisplayName("생성된 자동차들의 초기 position은 0이다")
    void createCarsWithInitialPosition() {
        // given
        List<String> carNames = List.of("pobi", "crong");

        // when
        List<RacingCar> cars = racingCarFactory.createCars(carNames);

        // then
        assertThat(cars)
                .extracting(RacingCar::getPosition)
                .containsOnly(0);
    }

    @Test
    @DisplayName("여러 대의 자동차를 생성한다")
    void createMultipleCars() {
        // given
        List<String> carNames = List.of("car1", "car2", "car3", "car4", "car5");

        // when
        List<RacingCar> cars = racingCarFactory.createCars(carNames);

        // then
        assertThat(cars).hasSize(5);
        assertThat(cars)
                .extracting(RacingCar::getName)
                .containsExactly("car1", "car2", "car3", "car4", "car5");
    }

    @Test
    @DisplayName("생성된 자동차들은 각각 독립적인 인스턴스다")
    void createIndependentInstances() {
        // given
        List<String> carNames = List.of("pobi", "crong");

        // when
        List<RacingCar> cars = racingCarFactory.createCars(carNames);
        RacingCar car1 = cars.get(0);
        RacingCar car2 = cars.get(1);

        car1.move(true);
        car1.move(true);

        // then
        assertThat(car1.getPosition()).isEqualTo(2);
        assertThat(car2.getPosition()).isEqualTo(0);  // 독립적이므로 영향 없음
    }

}
