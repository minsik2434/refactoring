package techniques.replace_temp_with_query;

public class Client {
    public static void main(String[] args) {
        MoviePriceCalculator calc1 = new MoviePriceCalculator(100.0, 2, true);
        System.out.println("customer1 total Price " + calc1.calculateTotalPrice());
        MoviePriceCalculator calc2 = new MoviePriceCalculator(120.0, 3, false);
        System.out.println("customer2 total Price " + calc2.calculateTotalPrice());
    }
}
