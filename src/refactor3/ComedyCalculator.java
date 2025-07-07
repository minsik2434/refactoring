package refactor3;

import base.Performance;
import base.Play;

public class ComedyCalculator extends PerformanceCalculator{
    public ComedyCalculator(Performance perf, Play play) {
        super(perf, play);
    }

    @Override
    public int amount() {
        int result = 30000;
        if(perf.getAudience() > 20){
            result += 10000 + 500 * (perf.getAudience() - 20);
        }
        return result + 300 * perf.getAudience();
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (int) Math.floor(perf.getAudience() / 5.0);
    }
}
