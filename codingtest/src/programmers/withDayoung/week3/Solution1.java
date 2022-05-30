package programmers.withDayoung.week3;

import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12982  Summer/Winter Coding(~2018) > 예산
 *
 * sort 후 비교
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(new int[]{1, 3, 2, 5, 4}, 9));
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int deptBudget : d) {
            if (budget >= deptBudget) {
                budget = budget - deptBudget;
                ++answer;
            }
        }

        // 스트림으로 바꾸기 -> 불가 : 람다 표현식에서는 final과 effective final변수만 사용 가능하다?
        /*
            int effectiveFinal = budget;
            int count = (int) Arrays.stream(d).sorted().filter(p -> {
            if (effectiveFinal >= p) {
                effectiveFinal = effectiveFinal - p; // 이 부분이 불가능
                return true;
            } else {
                return false;
            }
        }).count();*/

        return answer;
    }
}
