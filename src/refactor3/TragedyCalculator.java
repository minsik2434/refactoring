package refactor3;

import base.Performance;
import base.Play;

public class TragedyCalculator extends PerformanceCalculator{
    public TragedyCalculator(Performance perf, Play play) {
        super(perf, play);
    }

    @Override
    public int amount() {
        int result = 40000;
        if(perf.getAudience() > 30){
            result += 1000 * (perf.getAudience() - 30);
        }
        return result;
    }
}
