package refactor2;

public class EnrichedPerformance {
    private String playName;
    private String amountFormat;
    private int audience;

    public EnrichedPerformance(String playName, String amount, int audience) {
        this.playName = playName;
        this.amountFormat = amount;
        this.audience = audience;
    }

    public String getPlayName() {
        return playName;
    }

    public int getAudience() {
        return audience;
    }

    public String getAmountFormat() {
        return amountFormat;
    }
}
