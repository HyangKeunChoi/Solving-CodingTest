package inflearn.whiteship.interview._01_array_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolutions {

    public static void main(String[] args) {
        TwoSumSolutions twoSumSolutions = new TwoSumSolutions();
        System.out.println(Arrays.toString(twoSumSolutions.solution2(new int[]{2, 3, 4, 7}, 9)));
    }

    // 시간 O(N^2)
    // 공간 복잡도: O(1)
    private int[] solution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    // Map을 이욯
    // 하나의 숫자를 알면, 찾아야되는 다른 수는 자동적으로 알 수 있다.
    // Map의 containsKey와 get은 O(1)
    // 시간 : O(N)
    // 공간 : O(N)
    private int[] solution2(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }

        // 추가 조건 - 같은 인덱스를 꺼내지 않아야한다, 3 + 3 = 6과 같은 경우
        for (int i = 0; i < numbers.length; i++) {
            int numberToFind = target - numbers[i];
            if(numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i ) {
                return new int[] {i, numberMap.get(numberToFind)};
            }
        }

        return null;
    }

    //  for (int i = 0; i < numbers.length; i++) 부분이 겹쳐서 한줄로 줄일 수 있다
    private int[] solution3(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
           int numberToFind = target - numbers[i];

           if (numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i) {
                return new int[] {i, numberMap.get(numberToFind)};
            }
            numberMap.put(numbers[i], i);
        }

        return null;
    }

}
