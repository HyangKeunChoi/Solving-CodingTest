package codility.lesson.lesson4_CountingElements;

import java.util.*;

public class PermCheck {

    public static void main(String[] args) {

        PermCheck permCheck = new PermCheck();

        int[] A = {4 , 1 , 3 ,2};
        System.out.println(permCheck.solution(A));
    }

    public int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 1; i <= A.length; i++) {
            if(A[i-1] != i) {
                return 0;
            }
        }

        return 1;
    }
}
