package codility.lesson.lesson4_CountingElements;

import java.util.Arrays;

// 참고 : https://medium.com/@ydh0256/codility-lesson-4-maxcounters-5ef8e0d4817e
// 조금 변형
public class MaxCounters {

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();

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
        int[] answer = new int[N];
        int max = 0;
        int maxCounter = 0;

        for(int num : A) {
            if(num == N + 1) {
                maxCounter = max;
            } else {
                if(answer[num-1] < maxCounter) {
                    answer[num-1] = maxCounter;
                }
                answer[num-1] += 1;

                max = Math.max(max, answer[num-1]);
            }
        }
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] < maxCounter) {
                answer[i] = maxCounter;
            }
        }
        return answer;
    }
}
