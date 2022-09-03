package codility.lesson.lesson8_Leader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dominator {
    int max = 0;
    int key;

    public static void main(String[] args) {

        Dominator dominator = new Dominator();

        int[] A = {3, 4, 3, 2, 3, 3, -1, 3, 3};

        int[] B = {2, 1, 1, 3};
        // System.out.println(dominator.solution(A));
        System.out.println(dominator.solution(B));
    }

    public int solution(int[] A) {

        Map<Integer, Integer> map = new HashMap();

        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (max < pair.getValue()) {
                max = pair.getValue();
                key = pair.getKey();
            }
        }

        for (int i = 0; i < A.length; i++) {
            if(A[i] == key && max > A.length / 2) return i;
        }

        return -1;
    }
}
