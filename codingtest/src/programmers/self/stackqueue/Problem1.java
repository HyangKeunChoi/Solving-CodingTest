package programmers.self.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 같은 숫자는 싫어
// !! 연속하는 숫자에 대한 문제!!!!!
// 첫번째와 마지막 OutOfBound 해결하는 방법!
public class Problem1 {

    public int[] solution(int[] arr) {

        List<Integer> list = new ArrayList<>();
        int value = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                list.add(arr[i]);
                value = arr[i];
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 스택을 이용한 풀이
    public int[] solution2(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n) {
                stack.add(n);
            }
        }

        int[] answer = new int[stack.size()];
        int index = 0;
        for (int n : stack) {
            answer[index++] = n;
        }

        return answer;
    }

    public static void main(String[] args) {

        Problem1 problem1 = new Problem1();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(problem1.solution(arr));
    }
}
