package programmers.withDayoung.week1;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/*
 * 2019 KAKAO BLIND RECRUITMENT
 * map의 value로 정렬하기
 * double오름차순 정렬
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(3, new int[]{1,1,1});
    }

    public int[] solution(int N, int[] stages) {
        Map map = new HashMap();
        double failRate = 0;
        int matchedCount = 0;
        int copyCount = 0;

        for (int i =1; i<= N; i ++) {
            int count = 0;
            for (int stage : stages) {
                if(i == stage) {
                    ++count;
                    ++matchedCount;
                }
            }

            if(count == 0) {
                failRate =0;
            } else {
                failRate = (double) count / (stages.length - copyCount);
            }
            copyCount = matchedCount;
            map.put(i, failRate);
        }

        // map의 value를 기준으로 정렬하기기
        List<Double> entries = new ArrayList<>(map.values());
        // 오름차순 //
        Collections.sort(entries, (a, b) -> b.compareTo(a));

        int[] answer = new int[entries.size()];

        for (int i =0; i< entries.size(); i ++) {
            for(int j = 1; j<=map.size(); j++) {
                if(entries.get(i) == map.get(j) ) {
                    answer[i] = j;
                }
            }
        }

        return  answer;
    }
}
