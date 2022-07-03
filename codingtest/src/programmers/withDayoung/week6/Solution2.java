package programmers.withDayoung.week6;

import java.util.Arrays;

// 배열의 교집합 , 차집합, 합집합
public class Solution2 {
    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

        int[] a = {44, 1, 0, 0, 31, 25};
        int[] b = {31, 10, 45, 1, 6, 19};

        solution2.solution(a,b);
    }

    public int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int matchedCount = 0;
        for (int num : win_nums) {
            // 주의 : 정렬 + 0이상으로 체크 해야한다.
            if(Arrays.binarySearch(lottos, num) >= 0) {
                matchedCount++;
            }
        }

        int zeroCount = (int) Arrays.stream(lottos).filter(i -> i == 0).count();

        // Math.min, Math.max 함수 공부
        // int[] answer = {7-Math.max(matchedCount+count,1),7-Math.max(matchedCount,1)};
        int[] answer = { Math.min(7-(matchedCount+zeroCount), 6), Math.min(7-matchedCount,6)};

        return answer;
    }


}
