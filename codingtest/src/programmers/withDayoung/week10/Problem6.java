package programmers.withDayoung.week10;

import java.util.Stack;

// DFS BFS
// 네트워크 - 그래프의 개수가 몇개인지 맞추는 문제
public class Problem6 {

    public static boolean[] checked;
    public static int[][] computers;
    public static int count = 0;

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();

        int[][] arr = {
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };

        int[][] arr2 = {
                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        };

        //System.out.println(problem6.solution(3, arr));
        System.out.println(problem6.solution(3, arr2));
    }

    public int solution(int n, int[][] computers) {

        this.computers = computers;
        this.checked = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (checked[i] == false) {
                DFS(i);
                count++;
            }
        }
        return count;
    }

    private void DFS(int startnum) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startnum);
        checked[startnum] = true;

        while (!stack.isEmpty()) {
            for (int i = 0; i < computers.length; i++) {
                if (computers[startnum][i] == 1 && checked[i] == false && i != startnum) {
                    DFS(i);
                }
            }
            stack.pop();
        }
    }
}
