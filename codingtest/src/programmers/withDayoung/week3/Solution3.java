package programmers.withDayoung.week3;

/*
 * 약수의 합
 */
public class Solution3 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
