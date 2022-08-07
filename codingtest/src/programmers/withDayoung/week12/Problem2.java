package programmers.withDayoung.week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        int[] progress2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(problem2.solution(progress2, speeds2)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();

        // 1. 한 개 기능을 개발한 날짜를 계산
        for (int i = 0; i < progresses.length; i++) {
            double days = (100 - progresses[i]) / (double) speeds[i];
            int daysUp = (int) Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1;
            for (; j < progresses.length; j++) {
                if (progresses[j] + daysUp * speeds[j] < 100) {
                    break;
                }
            }
            // 3. 이번에 배포할 기능의 개수를 추가하기
            answer.add(j - i);
            i = j - 1; // 다음 배포는 이전 배포를 제외한 다음에 그 다음 배포일로 계산 되어야 하므로
        }

        /* TODO : stream으로 변환
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }*/
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
