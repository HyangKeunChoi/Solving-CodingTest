package selfPratice;

import java.util.*;

// 릿 코드
// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestNumber {

    public static void main(String[] args) {
        LongestNumber longestNumber = new LongestNumber();

        int[] nums = {100, 4, 200, 1, 3, 2};

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};

        int[] nums3 = {9,1,4,7,3,-1,0,5,8,-1,6};

        int[] nums4 = {1,2,0,1};
        System.out.println(longestNumber.longestConsecutive(nums));
        System.out.println(longestNumber.longestConsecutive(nums2));
        System.out.println(longestNumber.longestConsecutive(nums3));
        System.out.println(longestNumber.longestConsecutive(nums4));
    }

    public int longestConsecutive(int[] nums) {
        int count = 0;
        int max = 0;
        if(nums.length == 0) {
            return 0;
        }

        // 중복 제거
        Set set = new HashSet();
        for (int a: nums) {
            set.add(a);
        }

        List<Integer> list = new ArrayList(set);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 정렬
        Arrays.sort(answer);

        for (int i = 0; i < answer.length-1; i++) {
            if(answer[i]+1 == answer[i+1]) {
                max++;
                count = Math.max(count, max);
            } else {
                max = 0;
            }
        }

        if(count == 0) {
            return 1;
        } else {
            return count + 1;
        }
    }
}
