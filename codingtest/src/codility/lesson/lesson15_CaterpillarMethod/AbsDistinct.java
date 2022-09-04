package codility.lesson.lesson15_CaterpillarMethod;

import java.util.HashSet;
import java.util.Set;

public class AbsDistinct {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            set.add(Math.abs(a));
        }

        return set.size();
    }
}
