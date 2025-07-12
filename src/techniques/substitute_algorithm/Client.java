package techniques.substitute_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // --- 테스트 케이스 준비 및 실행 ---
        // Test Case 1
        List<Integer> data1 = Arrays.asList(5, 2, 8, 1, 9, 3);
        MaxFinder finder1 = new MaxFinder(data1);
        int result1 = finder1.findMax();
        int expected1 = 9;
        System.out.println("Test Case 1: Max in " + data1 + " is " + result1 + ". Expected: " + expected1 + (result1 == expected1 ? " (PASS)" : " (FAIL)"));

        // Test Case 2
        List<Integer> data2 = Arrays.asList(10, 20, 5, 15);
        MaxFinder finder2 = new MaxFinder(data2);
        int result2 = finder2.findMax();
        int expected2 = 20;
        System.out.println("Test Case 2: Max in " + data2 + " is " + result2 + ". Expected: " + expected2 + (result2 == expected2 ? " (PASS)" : " (FAIL)"));

        // Test Case 3: Single element
        List<Integer> data3 = Arrays.asList(7);
        MaxFinder finder3 = new MaxFinder(data3);
        int result3 = finder3.findMax();
        int expected3 = 7;
        System.out.println("Test Case 3: Max in " + data3 + " is " + result3 + ". Expected: " + expected3 + (result3 == expected3 ? " (PASS)" : " (FAIL)"));

        // Test Case 4: Negative numbers
        List<Integer> data4 = Arrays.asList(-5, -2, -8, -1);
        MaxFinder finder4 = new MaxFinder(data4);
        int result4 = finder4.findMax();
        int expected4 = -1;
        System.out.println("Test Case 4: Max in " + data4 + " is " + result4 + ". Expected: " + expected4 + (result4 == expected4 ? " (PASS)" : " (FAIL)"));

        // Test Case 5: Empty list (expected exception)
        try {
            new MaxFinder(new ArrayList<>()).findMax();
            System.out.println("Test Case 5: Empty list. Expected exception, but none thrown (FAIL)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 5: Empty list. Error: " + e.getMessage() + " (PASS)");
        }
    }
}
