package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    public void getCarsNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void getAttemptNumberMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getInput() {
        return Console.readLine();
    }
}
