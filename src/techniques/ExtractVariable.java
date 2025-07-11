package techniques;

public class ExtractVariable {
    double price(Order1 order1){
        // 가격 = (주문 상품 가격 * 주문 갯수) - 수량 할인 + 배송비
                //기본 가격
        return order1.quantity * order1.itemPrice -
                // 수량 할인
                Math.max(0, order1.quantity - 500) * order1.itemPrice * 0.05 +
                // 배송비
                Math.min(order1.quantity * order1.itemPrice * 0.1 , 100);
    }
    double price2(Order1 order1){
        // 가격 = (주문 상품 가격 * 주문 갯수) - 수량 할인 + 배송비
        //기본 가격
        int basePrice = order1.quantity * order1.itemPrice;
        return basePrice -
                // 수량 할인
                Math.max(0, order1.quantity - 500) * order1.itemPrice * 0.05 +
                // 배송비
                Math.min(basePrice * 0.1 , 100);
    }
    double price3(Order1 order1){
        // 가격 = (주문 상품 가격 * 주문 갯수) - 수량 할인 + 배송비
        //기본 가격
        int basePrice = order1.quantity * order1.itemPrice;
        double quantityDiscount = Math.max(0, order1.quantity - 500) * order1.itemPrice * 0.05;
        double sipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + sipping;
    }

    static class Order1 {
        int quantity;
        int itemPrice;
    }
}
