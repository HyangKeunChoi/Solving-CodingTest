package codility.lesson.lesson4_CountingElements;

import java.util.Arrays;

public class MaxCounters_TimeComplexity {

    public static void main(String[] args) {
        MaxCounters_TimeComplexity maxCounters = new MaxCounters_TimeComplexity();

        int N = 5;
        int[] arr = {3, 4, 4, 6, 1, 4, 4};

        int N1 = 1;
        int[] arr2 = {2, 1, 1, 2, 1};

        int N2 = 5;
        int[] arr3 = {6, 6, 6, 6, 6, 6};

        //System.out.println(Arrays.toString(maxCounters.solution(N, arr)));
        System.out.println(Arrays.toString(maxCounters.solution(N1, arr2)));
        System.out.println(Arrays.toString(maxCounters.solution(N2, arr3)));

    }
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] answer = new int[N+1];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if(N+1 == A[i]) {
                Arrays.fill(answer, max);
            } else {
                max = Math.max(answer[A[i] - 1] + 1, max);
                answer[A[i] - 1] = answer[A[i] - 1] + 1;
            }
        }

        int[] reAnswer = new int[N];
        for (int i = 0; i < reAnswer.length; i++) {
            reAnswer[i] = answer[i];
        }

        return reAnswer;
    }
}
