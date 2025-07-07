package refactor3;

public class EnrichedPerformance {
    private String playName;
    private int amount;
    private int audience;
    private double credit;

    public EnrichedPerformance(String playName, int amount, int audience, double credit) {
        this.playName = playName;
        this.amount = amount;
        this.audience = audience;
        this.credit = credit;
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

    public double getCredit(){
        return credit;
    }
}
