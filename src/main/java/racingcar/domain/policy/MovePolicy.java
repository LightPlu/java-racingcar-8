package racingcar.domain.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class MovePolicy {

    private final static int MOVE_THRESHOLD = 4;

    public boolean carMoveCondition() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}
