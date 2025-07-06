package refactor3;

import java.util.List;

public class StatementData {
    private String customerName;
    private List<EnrichedPerformance> performances;
    private int totalAmount;
    private double totalCredits;

    public StatementData(String customerName, List<EnrichedPerformance> performances, int totalAmount, double totalCredits) {
        this.customerName = customerName;
        this.performances = performances;
        this.totalAmount = totalAmount;
        this.totalCredits = totalCredits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<EnrichedPerformance> getPerformances() {
        return performances;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public double getTotalCredits() {
        return totalCredits;
    }
}
