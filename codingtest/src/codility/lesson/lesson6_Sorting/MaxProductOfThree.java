package codility.lesson.lesson6_Sorting;

import java.util.Arrays;

// https://moonscode.tistory.com/128
public class MaxProductOfThree {

    public static void main(String[] args) {

        int[] A = {-3, 1, 2, -2, 5, 6};

        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();

        System.out.println(maxProductOfThree.solution(A));
    }

    public int solution(int[] A) {

        Arrays.sort(A);

        if(A[0] * A[1] * A[A.length-1] > A[A.length-3] * A[A.length-2] * A[A.length-1] ) {
            return A[0] * A[1] * A[A.length-1];
        }

        return A[A.length-3] * A[A.length-2] * A[A.length-1];
    }
}
