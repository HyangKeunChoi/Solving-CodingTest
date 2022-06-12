package programmers.withDayoung.week4;

/*
 * 최대 공약수, 최소 공배수
 * https://st-lab.tistory.com/154
 */
public class Solution4_GCD_LCM {

    public static void main(String[] args) {
        Solution4_GCD_LCM solution4_gcd_lcm = new Solution4_GCD_LCM();
        System.out.println(solution4_gcd_lcm.solution(1, 2));
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int d = gcd(n, m);
        answer[0] = d;
        answer[1] = n * m / d;

        return answer;
    }

    // 최대공약수 반복문 방식 -> selfPratice에 재귀방식 있음
    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b; // 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
}
