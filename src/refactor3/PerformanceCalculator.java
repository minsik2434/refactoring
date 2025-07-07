package refactor3;

import base.Performance;
import base.Play;


public abstract class PerformanceCalculator {
    protected Performance perf;
    protected Play play;

    public PerformanceCalculator(Performance perf, Play play) {
        this.perf = perf;
        this.play = play;
    }

    public abstract int amount();
    public int volumeCredits(){ //기본 적립 포인트 계산
        return Math.max(perf.getAudience() - 30, 0);
    }

    public static PerformanceCalculator create(Performance perf, Play play){
        switch (play.getType()){
            case "tragedy":
                return new TragedyCalculator(perf, play);
            case "comedy":
                return new ComedyCalculator(perf, play);
            default:
                throw new IllegalArgumentException("알 수 없는 장르" + play.getType());
        }
    }
}
