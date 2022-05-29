package programmers.withDayoung.week2;

import java.util.Arrays;

/*
 * 정렬 > K번째수 https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 2차원 배열의 길이 https://hianna.tistory.com/517
 *
 * 이해하기 쉽도록 변수로 할당해서 풀기
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int first = commands[i][0];
            int second = commands[i][1];
            int third = commands[i][2];

            // 복사본 배열 생성
            int[] copyArray = new int[second - first + 1];
            int count = 0;

            // 복사본 배열에 값을 할당한다.
            for (int j = first - 1; j < second; j++) {
                copyArray[count] = array[j];
                count++;
            }

            // 정렬
            Arrays.sort(copyArray);

            // 정답 배열에 값 할당
            answer[i] = copyArray[third - 1];
        }
        return answer;
    }
}
