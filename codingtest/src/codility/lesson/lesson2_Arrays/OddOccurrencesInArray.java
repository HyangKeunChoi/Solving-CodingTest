package codility.lesson.lesson2_Arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(oddOccurrencesInArray.solution(A));
    }

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() % 2 == 1) {
                return pair.getKey();
            }
        }

        return 0;
    }
}
