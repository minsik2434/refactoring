package refactor1;

import base.Invoice;
import base.Performance;
import base.Play;

import java.text.NumberFormat;
import java.util.*;

public class StatementMain_ReplaceTempWithQuery {
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
            //thisAmount 삭제
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if("comedy".equals(playFor(plays, perf).getType())){
                volumeCredits += Math.floor(perf.getAudience() / 5.0);
            }

            result.append(String.format("  %s: %s (%d석)\n", playFor(plays, perf).getName(),
                    //thisAmount를 사용하는 부분을 amountFor 을 사용하도록 변경
                    formatter.format(amountFor(perf, playFor(plays, perf))/100.0), perf.getAudience()));
            //thisAmount를 사용하는 부분을 amountFor 을 사용하도록 변경
            totalAmount += amountFor(perf, playFor(plays, perf));
        }

        result.append(String.format("총액 : %s\n", formatter.format(totalAmount / 100.0)));
        result.append(String.format("적립 포인트 : %.1f점\n",volumeCredits));
        return result.toString();
    }

    private static Play playFor(Map<String, Play> plays, Performance perf) {
        return plays.get(perf.getPlayId());
    }

    private static int amountFor(Performance perf, Play play){
        int result;
        switch (play.getType()){
            case "tragedy":
                result = 40000;
                if(perf.getAudience() > 30){
                    result += 1000 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if(perf.getAudience() > 20){
                    result += 10000 + 500 * (perf.getAudience() - 20);
                }
                result += 300 * perf.getAudience();
                break;
            default:
                throw new IllegalArgumentException("알수 없는 장르 : " + play.getType());
        }
        return result;
    }
}
