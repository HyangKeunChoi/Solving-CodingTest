package inflearn.lecture.section5_stackqueue;

// 후위식 (postfix)
// 인터뷰에 나오는 문제

// 연산만 뒤쪽으로 빠지는 것
// 스택

import java.util.Scanner;
import java.util.Stack;

// 숫자는 push
// 연산자 만나면 pop

// 문자 -48해야지 숫자
public class Problem4 {

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(problem4.solution(str));
    }

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x: str.toCharArray()) {

            // 숫자 인지 확인
            if(Character.isDigit(x)) {
                stack.push(x-48); // 문자 -48해야지 숫자
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') {
                    stack.push(lt+rt);
                } else if(x=='-') {
                    stack.push(lt-rt);
                } else if(x=='*') {
                    stack.push(lt*rt);
                } else if(x=='/') {
                    stack.push(lt/rt);
                }
            }
        }
        answer=stack.get(0);

        return answer;

    }
}
