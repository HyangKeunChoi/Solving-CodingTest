package codility.lesson.lesson9_MaximumSliceProblem;

// Kadane’s Algorithm (카데인 알고리즘)
// O(n)
// 최대 부분합
// https://myung6024.tistory.com/57
public class MaxSliceSum {

    public static void main(String[] args) {
        MaxSliceSum maxSliceSum = new MaxSliceSum();

        int[] C = {-1, -2, -3, -4, -5};
        int[] A = {-2, 1};
        int[] B = {3, -2, 3};

        // System.out.println(maxSliceSum.solution(C));
        // System.out.println(maxSliceSum.solution(A));
        System.out.println(maxSliceSum.solution(B));
    }

    public int solution(int[] A) {
        if (A.length == 1) return A[0];

        int localMaxSum = A[0];
        int globalMaxSum = A[0];

        for (int i = 1; i < A.length; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            globalMaxSum = Math.max(globalMaxSum, localMaxSum);
        }
        return globalMaxSum;
    }
}

