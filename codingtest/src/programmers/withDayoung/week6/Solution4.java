package programmers.withDayoung.week6;

import java.util.stream.IntStream;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String[] s = {"jane", "Kim"};
        System.out.println(solution4.solution(s));
    }

    public String solution(String[] seoul) {
        int index = IntStream.range(0, seoul.length)
                .filter(i -> "Kim".equals(seoul[i]))
                .findFirst()
                .orElse(-1);

        return "김서방은 " + index + "에 있다";
    }
}
