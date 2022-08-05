package codility.lesson.lesson3_timecComplexity;

import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int[] a = {2, 3, 1, 5};
        System.out.println(permMissingElem.solution(a));
    }

    public int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if(A[i] != i+1) {
                return i+1;
            }
        }
        return A.length+1; // 마지막이 없는경우는 마지막 길이 + 1
    }
}
