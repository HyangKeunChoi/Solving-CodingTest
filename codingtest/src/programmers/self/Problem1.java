package programmers.self;

import java.util.Arrays;

// 숫자게임
public class Problem1 {

    public static void main(String[] args) {

    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        int index = 0;
        for (int i = 0; i < B.length; i++) {
            if(A[index] >= B[i]) {
                continue;
            }
            index++;
            answer++;
        }

        return answer;
    }
}
