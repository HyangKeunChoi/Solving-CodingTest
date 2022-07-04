package programmers.withDayoung.week7;

/*
 * 월간 코드 챌린지 시즌2 > 약수의 개수와 덧셈
 * 2중 for문 해결 할 수 있나?
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(13, 17));
        System.out.println(solution1.solution(24, 27));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left ; i<=right; i++) {
            int count = 0;
            
            // 약수의 개수 구하기
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }
            
            // 약수의 갯수가 짝수인경우
            if(count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}
