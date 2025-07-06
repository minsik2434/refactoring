package refactor2;

import base.Invoice;
import base.Performance;
import base.Play;

import java.text.NumberFormat;
import java.util.*;
/*
    1. ExtractMethod_renderer
    2. AddDataTransferObject
    3. ExtractMethod_CreateStatementData
    4. AddHtmlRender
 */
public class StatementMain {
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
        StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + invoice.getCustomer() + ") \n");
        for(Performance perf : invoice.getPerformance()){
            result.append(String.format("  %s: %s (%d석)\n", playFor(plays, perf).getName(),
                    won(amountFor(perf, playFor(plays, perf))), perf.getAudience()));
        }
        result.append(String.format("총액 : %s\n", won(totalAmount(invoice, plays))));
        result.append(String.format("적립 포인트 : %.1f 점\n",totalVolumeCredits(invoice, plays)));
        return result.toString();
    }

    private static int totalAmount(Invoice invoice, Map<String, Play> plays){
        int result = 0;
        for(Performance perf : invoice.getPerformance()){
            result += amountFor(perf, playFor(plays, perf));
        }
        return result;
    }

    private static double totalVolumeCredits(Invoice invoice, Map<String, Play> plays) {
        double result = 0;
        for(Performance perf : invoice.getPerformance()){
            result += volumeCreditsFor(perf, plays);
        }
        return result;
    }

    static String won(double number){
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(number / 100.0);
    }

    static double volumeCreditsFor(Performance perf, Map<String, Play> plays){
        double result = 0;
        result += Math.max(perf.getAudience() - 30,0);
        if("comedy".equals(playFor(plays,perf).getType())){
            result += Math.floor(perf.getAudience() / 5.0);
        }
        return result;
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
