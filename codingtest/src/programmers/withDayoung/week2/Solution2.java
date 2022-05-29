package programmers.withDayoung.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 완주하지 못한선수 (해시) https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 성공 풀이
 *
 * https://www.youtube.com/watch?v=_2yD46UxSso
 *
 * 두 배열의 중복 요소 제거하기
 *
 *  교집합, 합집합, 차집합 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution1(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    // 1. 두 배열을 정렬한다.
    // 2. 두 배열이 다를때까지 찾는다.
    // 3. 여기까지 왔다면, 마지막 주자가 완주하지 못한 선수다.
    public String solution1(String[] participant, String[] completion) {
        // 1. 두 배열 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를때까지 찾는다.
        int i = 0;
        for (; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                break;
        }

        // 3. 두 배열이 같지않다면 i번째 리턴 or 마지막 주자가 완주하지 못한선수
        return participant[i];
    }

    // 풀이 2 : hash 이용하기
    // 1. key에 선수 이름, value에 카운트를 갖는 hashmap을 만든다.
    // 2. completion에 존재하는 선수들의 hash 카운트를 차감한다
    // 3. value가 남아 있는 선수(0이 아닌)가 완주하지 못한 선수이다.
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        // 1. hashmap 생성
        Map<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. 뺀다
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 3. value가 0이 아닌 마지막 주자를 찾는다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        /* TODO : 좀더 성능에 신경을 쓴다면 iterator를 활용한다.
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        */

        return answer;
    }
}
