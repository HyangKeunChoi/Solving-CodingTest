package programmers.withDayoung.week4;

import java.util.HashSet;

/*
 * 탐욕법 , 체육복 문제
 * https://www.youtube.com/watch?v=Fbw7A4CS_-A
 *
 */
public class Solution1_greedy_GymSuit {

    public static void main(String[] args) {
        Solution1_greedy_GymSuit solution1 = new Solution1_greedy_GymSuit();
        System.out.println(solution1.solution1(5, new int[]{2,4}, new int[]{1,3,5}));
    }

    // 여벌을 최대한 빌려주기
    // set을 활용
    // 1. set을 만든다.
    // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다.
    // 3. 전체 학생 수에서 lostSet에 남은 학생수를 뺴준다.
    public int solution1(int n, int[] lost, int[] reserve) {

        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        // 1. set을 만든다.
        for (int i : reserve) {
            resSet.add(i);
        }
        for (int i : lost) {
            if(resSet.contains(i)) {
                resSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }

        // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다.
        for (int i : resSet) {
            if(lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if(lostSet.contains(i+1)) {
                lostSet.remove(i+1);
            }
        }

        // 3. 전체 학생 수에서 lostSet에 남은 학생수를 뺴준다
        return n - lostSet.size();
    }

    // Array를 이용
    public int solution2(int n, int[] lost, int[] reserve) {

        // n보다 앞뒤로 1개씩(총 2개) 더큰 배열 선언언
        // 1. student배열 생성
        int[] students = new int[n + 2];
        int answer = 0;
        // 2. reserve / lost 정보 반영
        for (int i : lost) {
            students[i]--;
        }
        for (int j : reserve) {
            students[j]++;
        }

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for (int i = 1; i <= n; i++) {
            if (students[i] == 1) {
                if (students[i - 1] == -1) {
                    students[i]--;
                    students[i - 1]++;
                } else if (students[i + 1] == -1) {
                    students[i]--;
                    students[i + 1]++;
                }
            }
        }
        // 4. 체육복을 갖고 있는 학생수를 계산한다. (배열에서 0보다 큰사람 갯수)
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0)
                answer++;
        }
        return answer;
    }
}
