package programmers.withDayoung.week1;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(45));
    }
    public int solution(int n) {
        // 3진법
        String ternary = Integer.toString(n, 3);

        // 문자열 reverse
        StringBuffer sb = new StringBuffer(ternary);
        String reverse = sb.reverse().toString();

        return Integer.parseInt(reverse,3);
    }
}
