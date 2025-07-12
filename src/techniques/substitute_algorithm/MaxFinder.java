package techniques.substitute_algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxFinder {
    private List<Integer> numbers;

    public MaxFinder(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int findMax(){
        return findMaxEfficiently();
    }

    private int findMaxEfficiently() {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        int max = numbers.get(0); // 첫 번째 요소를 초기 최댓값으로 설정
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i); // 현재 최댓값보다 크면 업데이트
            }
        }
        return max;
    }
}
