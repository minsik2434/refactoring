package refactor3;

import base.Invoice;
import base.Performance;
import base.Play;

import java.text.NumberFormat;
import java.util.*;

public class StatementMain_PerformanceCalculator {
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
        String htmlResult = htmlStatement(invoice, plays);
        System.out.println(result);
        System.out.println(htmlResult);
    }


    static String statement(Invoice invoice, Map<String, Play> plays){
        return renderPlainText(createStatementData(invoice, plays));
    }

    static String htmlStatement(Invoice invoice, Map<String,Play> plays){
        return renderHtml(createStatementData(invoice,plays));
    }

    private static StatementData createStatementData(Invoice invoice, Map<String, Play> plays) {
            List<EnrichedPerformance> enPerf = enrichPerformance(invoice, plays);
            return new StatementData(
                    invoice.getCustomer(),
                    enPerf,
                    totalAmount(invoice, plays),
                    totalVolumeCredits(invoice, plays)
            );
    }

    private static List<EnrichedPerformance> enrichPerformance(Invoice invoice, Map<String, Play> plays) {
        return invoice.getPerformance().stream()
                .map(perf -> {
                    PerformanceCalculator calculator = new PerformanceCalculator(perf, playFor(plays, perf));
                    return new EnrichedPerformance(
                            playFor(plays,perf).getName(),
                            calculator.amount(),
                            perf.getAudience()
                            );

                }).toList();
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

    private static String renderHtml(StatementData data){
        StringBuilder result = new StringBuilder("<h1>청구 내역 (고객명 : " + data.getCustomerName() + ")</h1> \n");
        result.append("<table>\n");
        result.append("  <tr><th>연극</th><th>좌석수</th><th>금액</th></tr>\n");
        for(EnrichedPerformance perf : data.getPerformances()){
            result.append(String.format(
                    "  <tr><td>%s</td><td>%d</td><td>%s</td></tr>\n",
                    perf.getPlayName(),
                    perf.getAudience(),
                    won(perf.getAmount())
            ));
        }
        result.append("</table>\n");
        result.append(String.format("<p>총액 : <em>%s</em></p>\n", won(data.getTotalAmount())));
        result.append(String.format("<p>적립 포인트 : <em>%.1f</em> 점</p>\n", data.getTotalCredits()));
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
