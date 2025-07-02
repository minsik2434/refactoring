package base;

import java.util.List;

public class Invoice {
    private String customer;
    private List<Performance> performance;

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformance() {
        return performance;
    }

    public Invoice(String customer, List<Performance> performance) {
        this.customer = customer;
        this.performance = performance;
    }
}
