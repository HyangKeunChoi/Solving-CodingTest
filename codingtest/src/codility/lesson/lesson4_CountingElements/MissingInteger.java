package codility.lesson.lesson4_CountingElements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();

        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(missingInteger.solution(A));
    }

    public int solution(int[] A) {

        Set<Integer> set = new HashSet<>();
        for (int a: A) {
            set.add(a);
        }

        for (int i = 0; i < set.size(); i++) {
            if(!set.contains(i+1)) {
                return i+1;
            }
        }

        return set.size() + 1;

    }
}
