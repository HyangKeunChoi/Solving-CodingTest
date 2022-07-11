package inflearn.whiteship.interview._01_array_04;

import java.util.Arrays;

public class SortByArraySolution {

    public static void main(String[] args) {

        // 정렬 알고리즘은 보통 빠른게 O(NlogN)인데 어떻게 O(N)으로 하라는 건가?
        // 이미 입력값이 1~100개중 50개라는 곳에서 힌트

        // 미리 사이즈 100인 boolean배열을 생성하고 거기에 해당하는 index를 true로 설정정

       SortByArraySolution sortByArray = new SortByArraySolution();
        System.out.println(Arrays.toString(sortByArray.solution(new int[]{2, 4, 1, 5, 6, 9})));
    }

    private int[] solution(int[] numbers) {
        boolean[] booleans = new boolean[100];
        for (int num : numbers) {
            booleans[num] = true;
        }

        int index = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                numbers[index++] = i;
            }
        }

        return numbers;
    }

}
