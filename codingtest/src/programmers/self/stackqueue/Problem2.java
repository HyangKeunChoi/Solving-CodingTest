package programmers.self.stackqueue;

import java.util.Stack;

// 짝지어 제거하기
public class Problem2 {

    public static void main(String[] args) {
        Problem2 mono = new Problem2();
        System.out.println(mono.solution("baabaa"));
        System.out.println(mono.solution("cdcd"));

        System.out.println(mono.solution("cccdd"));
        System.out.println(mono.solution("c"));
        System.out.println(mono.solution("bb"));
        System.out.println(mono.solution("aab"));
        System.out.println(mono.solution("aabb"));


    }

    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
