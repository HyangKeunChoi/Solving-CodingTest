package codility.lesson.lesson7_StacksandQueues;

import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char s: S.toCharArray()) {
            if(stack.isEmpty()) {
                if(s == ')') {
                    return 0;
                } else {
                    stack.add(s);
                }
            } else {
                if(s == ')') {
                    stack.pop();
                } else {
                    stack.add(s);
                }
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
