package programmers.withDayoung.week3;

/*
 * 수박수박수박...
 */
public class Solution4 {

    public static void main(String[] args) {

    }

    public String solution(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }
        return answer;
    }
}
