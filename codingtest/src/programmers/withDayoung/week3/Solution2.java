package programmers.withDayoung.week3;

/* 월간 코드 챌린지 시즌2 > 음양 더하기
 * 혹시나 음수로 변환하는 경우 있다면
 * a * -1 or Math.abs(n) 이용한다.
 *
 */
public class Solution2 {
    public static void main(String[] args) {

    }
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
