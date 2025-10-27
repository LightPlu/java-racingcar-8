package racingcar.domain.value;

public class RoundCount {

    private final int totalRound;

    public RoundCount(String totalRound) {
        validateInteger(totalRound);
        validatePositive(totalRound);
        this.totalRound = Integer.parseInt(totalRound);
    }

    public void validatePositive(String input) {
        int validateValue = Integer.parseInt(input);
        if (validateValue < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public int getRoundCount() {
        return totalRound;
    }
}
