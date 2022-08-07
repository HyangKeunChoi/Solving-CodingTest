package programmers.withDayoung.week12;

import java.util.*;

// 기능 개발 문제

// 풀기 실패 -> 아래 풀이 참고하였슴
// https://haruple.tistory.com/205
public class Problem2_fail {

    static Queue<Integer> queue;
    static int count;

    public static void main(String[] args) {
        Problem2_fail problem2 = new Problem2_fail();

        int[] progress = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] progress2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(problem2.solution(progress, speeds)));
        System.out.println(Arrays.toString(problem2.solution(progress2, speeds2)));
    }

    public int[] solution(int[] progresses, int[] speeds) {

        queue = new LinkedList<>();

        // 100이 될때까지 필요한 날짜 구하기
        for (int i = 0; i < speeds.length; i++) {
            while (progresses[i] < 100) {
                count++;
                progresses[i] = progresses[i] + speeds[i];
            }
            queue.offer(count);
            count = 0;
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
        // 출력 ArrayList -> Array
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
