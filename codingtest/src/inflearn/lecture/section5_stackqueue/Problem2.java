package inflearn.lecture.section5_stackqueue;

// stack
// 괄호문자 제거

// 스택도 인덱스
import java.util.Scanner;
import java.util.Stack;

// 소괄호 ()안의 문자 제거하고 남은 문자만 출력
public class Problem2 {

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        Scanner sc = new Scanner(System.in);

        String str=sc.next();
        System.out.println(problem2.solution(str));
    }

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {

            if(x ==')') {
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        // 스택도 인덱스로 가져올 수 있다.
        for (int i = 0; i < stack.size(); i++) {
            answer+=stack.get(i);
        }

        return answer;
    }


}
