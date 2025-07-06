package refactor2;

import base.Invoice;
import base.Performance;
import base.Play;

import java.text.NumberFormat;
import java.util.*;

public class StatementMain_AddDataTransferObject {
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
        List<EnrichedPerformance> enPerf = new ArrayList<>();
        for(Performance perf : invoice.getPerformance()){
            enPerf.add(new EnrichedPerformance(
                    playFor(plays, perf).getName(),
                    amountFor(perf, playFor(plays, perf)),
                    perf.getAudience()
            ));
        }
        StatementData data = new StatementData(
                invoice.getCustomer(),
                enPerf,
                totalAmount(invoice, plays),
                totalVolumeCredits(invoice, plays)
        );
        return renderPlainText(data);
    }

    private static String renderPlainText(StatementData data) {
        StringBuilder result = new StringBuilder("청구 내역 (고객명 : " + data.getCustomerName() + ") \n");
        for(EnrichedPerformance perf : data.getPerformances()){
            result.append(String.format("  %s: %s (%d석)\n", perf.getPlayName(),
                    won(perf.getAmount()), perf.getAudience()));
        }
        result.append(String.format("총액 : %s\n", won(data.getTotalAmount())));
        result.append(String.format("적립 포인트 : %.1f 점\n", data.getTotalCredits()));
        return result.toString();
    }

    private static int totalAmount(Invoice invoice, Map<String, Play> plays){
        return invoice.getPerformance().stream()
                .mapToInt(perf -> amountFor(perf, playFor(plays, perf)))
                .sum();
    }

    private static double totalVolumeCredits(Invoice invoice, Map<String, Play> plays) {
        return invoice.getPerformance().stream()
                .mapToDouble(perf -> volumeCreditsFor(perf, plays))
                .sum();
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
