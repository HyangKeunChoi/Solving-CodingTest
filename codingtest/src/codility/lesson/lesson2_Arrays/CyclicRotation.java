package codility.lesson.lesson2_Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CyclicRotation {

    public static void main(String[] args) {

        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        CyclicRotation cyclicRotation = new CyclicRotation();
        System.out.println(Arrays.toString(cyclicRotation.solution(A, K)));
    }

    public int[] solution(int[] A, int K) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = A.length - 1; i >= 0; i--) {
            q.offer(A[i]);
        }

        for (int i = 0; i < K; i++) {
            q.offer(q.poll());
        }

        for (int i = A.length - 1; i >= 0; i--) {
            A[i] = q.poll();
        }

        return A;
    }
}
