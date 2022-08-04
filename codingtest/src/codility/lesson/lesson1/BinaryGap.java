package codility.lesson.lesson1;

import java.util.Stack;

// 문자 -48해야지 숫자

// 맨 첫글자는 1일 수밖에 없다는 힌트를 발견

// 더 깔끔한 풀이
// https://kangfru.tistory.com/17
public class BinaryGap {

    public int solution(int N) {

        String binaryString = Integer.toBinaryString(N);
        Stack<Integer> stack = new Stack<>();

        int maxCount = Integer.MIN_VALUE;
        int count = 0;

        for (char c : binaryString.toCharArray()) {
            stack.push(c - 48);
        }

        boolean start = false;

        while (!stack.isEmpty()) {
            if (stack.peek() == 1) {
                stack.pop();
                start = true;
                count = 0;
            } else if (stack.peek() == 0 && start) {
                stack.pop();
                count++;
            } else {
                stack.pop();
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(529));
        System.out.println(binaryGap.solution(20));
        System.out.println(binaryGap.solution(51712));
    }
}
