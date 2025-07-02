package refactor1;

import base.Invoice;
import base.Performance;
import base.Play;

import java.text.NumberFormat;
import java.util.*;

public class StatementMain_ExtractMethod {
    public static void main(String[] args) {
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        List<Performance> performances = Arrays.asList(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        );

        Invoice invoice = new Invoice("BigCo", performances);
        String result = statement(invoice, plays);
        System.out.println(result);
    }

    static String statement(Invoice invoice, Map<String, Play> plays){
        int totalAmount = 0;
        double volumeCredits = 0;
        StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + invoice.getCustomer() + ") \n");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.KOREA);

        for(Performance perf : invoice.getPerformance()){
            Play play = plays.get(perf.getPlayId());
            // 추출된 메서드를 사용
            int thisAmount = amountFor(perf, play);
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if("comedy".equals(play.getType())){
                volumeCredits += Math.floor(perf.getAudience() / 5.0);
            }

            result.append(String.format("  %s: %s (%d석)\n", play.getName(),
                    formatter.format(thisAmount/100.0), perf.getAudience()));
            totalAmount += thisAmount;
        }

        result.append(String.format("총액 : %s\n", formatter.format(totalAmount / 100.0)));
        result.append(String.format("적립 포인트 : %s점\n",formatter.format(volumeCredits)));
        return result.toString();
    }

    private static int amountFor(Performance perf, Play play){
        int thisAmount;
        switch (play.getType()){
            case "tragedy":
                thisAmount = 40000;
                if(perf.getAudience() > 30){
                    thisAmount += 1000 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if(perf.getAudience() > 20){
                    thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                }
                thisAmount += 300 * perf.getAudience();
                break;
            default:
                throw new IllegalArgumentException("알수 없는 장르 : " + play.getType());
        }
        return thisAmount;
    }
}
