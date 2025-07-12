package techniques.replace_primitive_with_object;

public class Money {
    private double amount;

    public Money(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(amount, money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(amount).hashCode();
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }

    // Money 객체 간의 연산 (새로운 Money 객체를 반환)
    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money subtract(Money other) {
        return new Money(this.amount - other.amount);
    }

    public Money multiply(double factor) {
        return new Money(this.amount * factor);
    }
}
