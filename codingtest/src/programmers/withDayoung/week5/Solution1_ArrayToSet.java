package programmers.withDayoung.week5;

import java.util.*;
import java.util.stream.Collectors;

/*
 * array to set
 */
public class Solution1_ArrayToSet {

    public static void main(String[] args) {
        Solution1_ArrayToSet solution1 = new Solution1_ArrayToSet();
        solution1.solution(new int[]{3, 3, 3, 2, 2, 4});
    }

    public int solution(int[] nums) {

        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        if (nums.length / 2 <= collect.size()) {
            return nums.length / 2;
        } else {
            return collect.size();
        }
    }
}
