package selfPratice;

import java.util.Arrays;
import java.util.Collections;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// 릿코드 k번째 큰수
public class KthLargestElementinanArray {

    public static void main(String[] args) {

        int[] nums = {3, 2 , 1, 5, 6 ,4};
        int k = 2;

        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        System.out.println(kthLargestElementinanArray.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        Integer[] arr3 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr3, Collections.reverseOrder());

        return arr3[k-1];
    }
}
