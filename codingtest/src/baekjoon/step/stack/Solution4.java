package baekjoon.step.stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        Solution4 solution4 = new Solution4();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solution4.solution(bw, "So when I die (the [first] I will see in (heaven) is a score list).");
        solution4.solution(bw, "[ first in ] ( first out ).");
        solution4.solution(bw, "Half Moon tonight (At least it is better than no Moon at all].");
        solution4.solution(bw, "A rope may form )( a trail in a maze.");

        solution4.solution(bw, "Help( I[m being held prisoner in a fortune cookie factory)].");
        solution4.solution(bw, "([ (([( [ ] ) ( ) (( ))] )) ]).");
        solution4.solution(bw, " .");


        bw.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
        bw.close();
    }

    public void solution(BufferedWriter bw, String s) throws IOException {
        Stack stack = new Stack();

        String[] arr = s.split("");
        for (String s1 : arr) {
            if ("(".equals(s1) || "[".equals(s1)) {
                stack.push(s1);
            }

            if ("]".equals(s1)) {
                if (stack.isEmpty() || !"[".equals(stack.peek())) {

                } else {
                    stack.pop();
                }
            }

            if (")".equals(s1)) {
                if (stack.isEmpty() || !"(".equals(stack.peek())) {

                } else {
                    stack.pop();
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
