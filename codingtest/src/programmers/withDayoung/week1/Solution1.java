package programmers.withDayoung.week1;

import java.util.stream.IntStream;

/*
 * 월간 코드 챌린지 시즌3 > 없는 숫자 더하기
 *
 * array에서 일치하지 않는 수 찾기
 *
 */
public class Solution1 {
    public static void main(String[] args) {

        Solution1 main = new Solution1();
        System.out.println(main.solution(new int[]{1, 2, 3, 5}));
    }

    public int solution(int[] numbers) {
        int answer = 0;
        int[] zeroToNine = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int number : zeroToNine) {
            if(!IntStream.of(numbers).anyMatch(x -> x == number)) {
                answer += number;
            }
        }

        return answer;
    }
}