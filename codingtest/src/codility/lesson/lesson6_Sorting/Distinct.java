package codility.lesson.lesson6_Sorting;

import java.util.HashMap;
import java.util.Map;

public class Distinct {

    public static void main(String[] args) {
        Distinct distinct = new Distinct();

        int[] A = {2, 1, 1, 2, 3, 1};

        System.out.println(distinct.solution(A));
    }

    public int solution(int[] A) {

        Map<Integer, Integer> map = new HashMap();

        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        return map.size();
    }
}
