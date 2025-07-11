package techniques.splitphase;

public class OrderService {
    public static String generateOrderSummery(Order order){
        OrderData data = genOrderData(order);
        return formatSummary(data);
    }

    private static OrderData genOrderData(Order order) {
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice() * item.getQuantity();
        }
        return new OrderData(order.getCustomerName(), total);
    }

    private static String formatSummary(OrderData data) {
        return String.format(
                "** OrderSummery **" +
                        "CustomerName : %s%n" +
                        "Total: $%.2f%n",
                data.getTotal(), data.getTotal()
        );
    }
}
