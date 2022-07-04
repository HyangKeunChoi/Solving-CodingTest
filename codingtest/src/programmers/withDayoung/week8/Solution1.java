package programmers.withDayoung.week8;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        System.out.println(solution1.solution("abcde"));
        System.out.println(solution1.solution("qwer"));
    }
    public String solution(String s) {

        String[] arr= s.split("");
        int middle = arr.length/2 + 1;

        if(arr.length % 2 == 0) {
            return arr[middle-1] + arr[middle];
        } else {
            return arr[middle-1];
        }
    }
}
