package refactor3;

public class EnrichedPerformance {
    private String playName;
    private int amount;
    private int audience;

    public EnrichedPerformance(String playName, int amount, int audience) {
        this.playName = playName;
        this.amount = amount;
        this.audience = audience;
    }

    public String getPlayName() {
        return playName;
    }

    public int getAudience() {
        return audience;
    }

    public int getAmount() {
        return amount;
    }
}
