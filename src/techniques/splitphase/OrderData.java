package techniques.splitphase;

public class OrderData {
    private String customerName;
    private double total;

    public OrderData(String customerName, double total) {
        this.customerName = customerName;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotal() {
        return total;
    }
}
