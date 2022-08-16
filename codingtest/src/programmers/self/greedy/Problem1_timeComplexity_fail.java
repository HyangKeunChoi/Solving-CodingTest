package programmers.self.greedy;

// 큰수 만들기 : k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하기

// 조합으로 풀었음 n개중 r개 뽑기
// 테스트 케이스는 전부 통과하나........... 시간 초과

// 참고
// https://bcp0109.tistory.com/15
public class Problem1_timeComplexity_fail {

    static int max = 0;

    public String solution(String number, int k) {

        char[] arr = number.toCharArray();
        boolean[] visited = new boolean[arr.length];
        int[] intArr = new int[arr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(arr[i]));
        }

        for (int r = 1; r <= intArr.length; r++) {
            if (r == intArr.length - k) {
                combination(intArr, visited, 0, intArr.length, r);
            }
        }

        return String.valueOf(max);
    }

    public static void main(String[] args) {

        Problem1_timeComplexity_fail problem1 = new Problem1_timeComplexity_fail();

        System.out.println(problem1.solution("4177252841", 4));
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            calcuate(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void calcuate(int[] arr, boolean[] visited, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        max = Math.max(Integer.parseInt(String.valueOf(sb)), max);
    }
}
