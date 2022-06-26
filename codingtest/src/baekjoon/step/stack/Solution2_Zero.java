package baekjoon.step.stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution2_Zero {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < input; i++) {
            int newInput = scanner.nextInt();

            if(i == 0 && newInput == 0) {

            } if(newInput == 0) {
                stack.pop();
            } else {
                stack.push(newInput);
            }
        }

        int sum = 0;

        int size = stack.size(); // pop하면 사이즈가 바뀜

        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        System.out.println(sum);
        scanner.close();
    }


}
