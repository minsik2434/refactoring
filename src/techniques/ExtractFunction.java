package techniques;

import java.time.LocalDateTime;
import java.util.Date;

public class ExtractFunction {
    void printOwing(Invoice invoice){
        printBanner();

        int outstanding = calculateOutstanding(invoice);

        LocalDateTime today = LocalDateTime.now();
        invoice.dueDate = today.plusDays(30);

        printDetails(invoice, outstanding);
    }
    private int calculateOutstanding(Invoice invoice){
        int result = 0;
        for(int i : invoice.amount){
            result += i;
        }
        return result;
    }

    private static void printDetails(Invoice invoice, int outstanding) {
        System.out.println("고객명 : " + invoice.customer);
        System.out.println("채무액 : " + outstanding);
        System.out.println("마감일 : " + invoice.dueDate);
    }

    private static void printBanner() {
        System.out.println("-----");
        System.out.println("출력");
        System.out.println("-----");
    }

    static class Invoice{
        String customer;
        int[] amount;
        LocalDateTime dueDate;
    }
    int calculateOutStanding(){
        return 0;
    }

}
