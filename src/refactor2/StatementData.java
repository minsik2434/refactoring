package refactor2;

import java.util.List;

public class StatementData {
    private String customerName;
    private List<EnrichedPerformance> performances;
    private String totalAmountFormat;
    private double totalCredits;

    public StatementData(String customerName, List<EnrichedPerformance> performances, String totalAmount, double totalCredits) {
        this.customerName = customerName;
        this.performances = performances;
        this.totalAmountFormat = totalAmount;
        this.totalCredits = totalCredits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<EnrichedPerformance> getPerformances() {
        return performances;
    }

    public String getTotalAmountFormat() {
        return totalAmountFormat;
    }

    public double getTotalCredits() {
        return totalCredits;
    }
}
