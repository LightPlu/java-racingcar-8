package racingcar.domain.value;

public class RoundCount {

    private final int totalRound;

    public RoundCount(String totalRound) {
        validateTrim(totalRound);
        validateInteger(totalRound);
        validatePositive(totalRound);
        this.totalRound = Integer.parseInt(totalRound);
    }

    public void validateTrim(String input) {
        if (input.startsWith(" ") || input.endsWith(" ")) {
            throw new IllegalArgumentException("횟수 앞 뒤로 공백이 올 수 없습니다.");
        }
    }

    public void validatePositive(String input) {
        int validateValue = Integer.parseInt(input);
        if (validateValue < 0) {
            throw new IllegalArgumentException("시도할 횟수에는 음수가 올 수 없습니다.");
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수를 정수로 입력해주세요.");
        }
    }

    public int getRoundCount() {
        return totalRound;
    }
}
