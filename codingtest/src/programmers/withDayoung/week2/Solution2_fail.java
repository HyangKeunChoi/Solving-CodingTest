package programmers.withDayoung.week2;

import java.util.ArrayList;
import java.util.List;

/*
 * 완주하지 못한선수 https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 실패 풀이 : removeAll은 중복된 모든 값을 제거함
 *
 * 두 배열의 중복 요소 제거하기
 *
 * 확인한 개념 : 배열의 교집합, 합집합, 차집합
 */
public class Solution2_fail {
    public static void main(String[] args) {
        Solution2_fail solution2 = new Solution2_fail();
        System.out.println(solution2.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        // **Arrays.asList 에서 나오는 결과로는 동적 List를 만들 수 없다.**
        //List<String> list1 = Arrays.asList(participant);
        //List<String> list2 = Arrays.asList(completion);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (String s : participant) {
            list1.add(s);
        }
        for (String s2 : completion) {
            list2.add(s2);
        }

        // 실패 원인 : 중복된 요소까지 모두 제거함
        list1.removeAll(list2);

        String answer = "";
        for (String s : list1) {
            answer += s;
        }
        return answer;
    }
}
