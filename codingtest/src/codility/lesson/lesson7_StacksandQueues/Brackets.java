package codility.lesson.lesson7_StacksandQueues;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        String s = "{[()()]}";

        Brackets brackets = new Brackets();
        System.out.println(brackets.solution(s));
    }

    public int solution(String S) {

        Stack<Character> stack = new Stack();

        for (char s: S.toCharArray()) {
            if(s == '{' || s == '[' || s == '(') {
                stack.add(s);
            }
            if(!stack.isEmpty()) {
                if (s == '}' && stack.peek() == '{') {
                    stack.pop();
                }

                if (s == ']' && stack.peek() == '[') {
                    stack.pop();
                }

                if (s == ')' && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                stack.add(s);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
