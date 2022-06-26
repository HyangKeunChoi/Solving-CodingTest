package baekjoon.step.stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        Solution3 solution3 = new Solution3();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언

        solution3.solution(bw, "(())())");
        solution3.solution(bw, "(((()())()");
        solution3.solution(bw, "(()())((()))");
        solution3.solution(bw, "((()()(()))(((())))()");

        solution3.solution(bw, "()()()()(()()())()");
        solution3.solution(bw, "(()((())()(");

        bw.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
        bw.close();
    }

    public void solution(BufferedWriter bw, String s) throws IOException {

        Stack stack = new Stack();

        String[] arr = s.split("");
        for (String s1 : arr) {
            if ("(".equals(s1)) {
                stack.push(1);
            }
            if (")".equals(s1)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push(s1);
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("YES");
        } else {
            bw.write("NO");
            ;
        }

        bw.write("\n");
    }
}
