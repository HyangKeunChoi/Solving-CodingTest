package programmers.withDayoung.week9;

// 깊이/너비 우선 탐색(DFS/BFS) 타겟 넘버 - DFS
// https://www.youtube.com/watch?v=S2JDw9oNNDk
// 조합
public class Solution4 {
    int[] numbers;
    int target;
    int answer;

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        return answer;
    }

    void dfs(int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
