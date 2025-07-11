package techniques;

public class Order {
    private int quantity;
    private int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(){
        return basePrice() - quantityDiscount() + shipping();
    }

    public int basePrice(){
        return this.quantity * this.itemPrice;
    }

    public double quantityDiscount() {
        return Math.max(0, this.quantity - 500) * this.itemPrice * 0.05;
    }
    public double shipping(){
        return Math.max(this.basePrice() * 0.1, 100);
    }
}
