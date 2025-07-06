package refactor3;

import base.Performance;
import base.Play;

import java.util.Map;

public class PerformanceCalculator {
    private Performance perf;
    private Play play;

    public PerformanceCalculator(Performance perf, Play play) {
        this.perf = perf;
        this.play = play;
    }

     public int amount(){
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
