package techniques.replace_temp_with_query;

public class MoviePriceCalculator {
    private double basePrice;
    private int quantity;
    private boolean isSpecialCustomer;

    public MoviePriceCalculator(double basePrice, int quantity, boolean isSpecialCustomer) {
        this.basePrice = basePrice;
        this.quantity = quantity;
        this.isSpecialCustomer = isSpecialCustomer;
    }
    //할인율을 반환하는 함수로 추출
    private double getDiscountRate() {
        if(isSpecialCustomer){
            return 0.1;
        } else {
            return 0.05;
        }
    }
    //가격을 반환하는 함수로 추출
    private double getBaseAmount(){
        return basePrice * quantity;
    }
    //한인 금액을 반환하는 함수로 추출
    private double getDiscountAmount(){
        return getBaseAmount() * getDiscountRate();
    }

    public double calculateTotalPrice(){
        // 임시변수 없이 질의 함수를 직접 사용
        return getBaseAmount() - getDiscountAmount();
    }
}
