package programmers.self.greedy;

// 그리디
// 큰수 만들기 : k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하기

// 설명 잘되어 있는곳 : https://born2bedeveloper.tistory.com/27
// 소스 참고한곳 : https://moon1226.tistory.com/67

public class Problem1 {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        char max;
        for (int i = 0; i < number.length() - k; i++) {
            max = '0';

            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);  // 최댓값 찾기
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
