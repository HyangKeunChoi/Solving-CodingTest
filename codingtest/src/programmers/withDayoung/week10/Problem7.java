package programmers.withDayoung.week10;

import java.util.HashMap;
import java.util.Map;

// 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Problem7 {

    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap();

        int multiple = brown + yellow;
        for (int i = 1; i <= multiple; i++) {
            if(multiple % i == 0 ) {
                map.put(i, multiple / i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int y = entry.getValue();

            if(x >= y) {
                if((x * 2) + (y * 2 - 4) == brown) {
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }
        return answer;
    }
}
