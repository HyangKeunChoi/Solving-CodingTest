package codility.lesson.lesson9_MaximumSliceProblem;

public class MaxProfit {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        int min = Integer.MAX_VALUE; // 값 초기화
        int max = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] < min) {
                min = A[i];
            } else if (A[i] - min > max) {
                max = A[i] - min;
            }
        }
        return max;
    }
}
