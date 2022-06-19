package programmers.withDayoung.week5;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(987));
    }

    public int solution(int n) {
        int answer = 0;

        String[] splitArr = Integer.toString(n).split("");

        /*for (String s : splitArr) {
            answer += Integer.parseInt(s);
        }*/

        // 스트림으로 풀기
        return Arrays.stream(splitArr).mapToInt(Integer::parseInt).reduce((i, j) -> i = i + j).getAsInt();
    }
}
