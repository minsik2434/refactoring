package techniques;

public class InlineFunction {

    int getRating(Driver driver){
        return (driver.numberOfLateDeliveries > 5) ? 2 : 1;
    }

    boolean moreThanFiveLateDeliveries(Driver driver){
        return driver.numberOfLateDeliveries > 5;
    }

    static class Driver{
        int numberOfLateDeliveries = 10;
    }
}
