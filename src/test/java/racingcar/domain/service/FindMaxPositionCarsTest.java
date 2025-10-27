package racingcar.domain.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;

class FindMaxPositionCarsTest {

    private FindMaxPositionCars findMaxPositionCars;

    @BeforeEach
    void setUp() {
        findMaxPositionCars = new FindMaxPositionCars();
    }

    @Test
    @DisplayName("최대 position을 찾는다")
    void findMaxPosition() {
        // given
        RacingCar car1 = new RacingCar("pobi");
        car1.move(true);
        car1.move(true);

        RacingCar car2 = new RacingCar("crong");
        car2.move(true);
        car2.move(true);
        car2.move(true);

        RacingCar car3 = new RacingCar("honux");
        car3.move(true);

        List<RacingCar> cars = List.of(car1, car2, car3);

        // when
        int maxPosition = findMaxPositionCars.findMaxPosition(cars);

        // then
        assertThat(maxPosition).isEqualTo(3);
    }

    @Test
    @DisplayName("모든 자동차가 같은 position일 때 최대값을 찾는다")
    void findMaxPositionWhenAllSame() {
        // given
        RacingCar car1 = new RacingCar("pobi");
        car1.move(true);
        car1.move(true);

        RacingCar car2 = new RacingCar("crong");
        car2.move(true);
        car2.move(true);

        List<RacingCar> cars = List.of(car1, car2);

        // when
        int maxPosition = findMaxPositionCars.findMaxPosition(cars);

        // then
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("단독 우승자를 찾는다")
    void findSingleWinner() {
        // given
        RacingCar car1 = new RacingCar("pobi");
        car1.move(true);
        car1.move(true);
        car1.move(true);

        RacingCar car2 = new RacingCar("crong");
        car2.move(true);

        RacingCar car3 = new RacingCar("honux");
        car3.move(true);
        car3.move(true);

        List<RacingCar> cars = List.of(car1, car2, car3);
        int maxPosition = findMaxPositionCars.findMaxPosition(cars);

        // when
        List<RacingCar> winners = findMaxPositionCars.findMaxPositionCars(cars, maxPosition);

        // then
        assertThat(winners)
                .hasSize(1)
                .extracting(RacingCar::getName)
                .containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자를 모두 찾는다")
    void findMultipleWinners() {
        // given
        RacingCar car1 = new RacingCar("pobi");
        car1.move(true);
        car1.move(true);
        car1.move(true);

        RacingCar car2 = new RacingCar("crong");
        car2.move(true);
        car2.move(true);
        car2.move(true);

        RacingCar car3 = new RacingCar("honux");
        car3.move(true);

        List<RacingCar> cars = List.of(car1, car2, car3);
        int maxPosition = findMaxPositionCars.findMaxPosition(cars);

        // when
        List<RacingCar> winners = findMaxPositionCars.findMaxPositionCars(cars, maxPosition);

        // then
        assertThat(winners)
                .hasSize(2)
                .extracting(RacingCar::getName)
                .containsExactlyInAnyOrder("pobi", "crong");
    }

    @Test
    @DisplayName("모든 자동차가 이동하지 않는다면 예외가 발생한다")
    void throwErrorWhenNoMove() {
        // given
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("crong");

        List<RacingCar> cars = List.of(car1, car2);
        car1.move(false);
        car2.move(false);

        // then
        assertThatThrownBy(() -> new FindMaxPositionCars().findMaxPosition(cars))
                .hasMessageContaining("아무 자동차도 전진하지 못하여 우승자는 없습니다.");
    }

}
