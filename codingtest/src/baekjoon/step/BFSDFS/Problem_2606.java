package baekjoon.step.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 바이러스
public class Problem_2606 {
    static int[][] matrix;
    static int[] check;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String vertex = bf.readLine();
        String line = bf.readLine();

        matrix = new int[Integer.parseInt(vertex) + 1][Integer.parseInt(vertex) + 1];
        check = new int[Integer.parseInt(vertex) + 1];

        for (int i = 0; i < Integer.parseInt(line); i++) {
            String[] splitInput = bf.readLine().split(" ");
            matrix[Integer.parseInt(splitInput[0])][Integer.parseInt(splitInput[1])] = 1;
            matrix[Integer.parseInt(splitInput[1])][Integer.parseInt(splitInput[0])] = 1;
        }
        System.out.println(DFS(1) - 1);
    }

    public static int DFS(int startnum) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startnum);
        check[startnum] = 1;
        cnt++;

        while (!stack.isEmpty()) {
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[startnum][i] == 1 && check[i] == 0) {
                    DFS(i);
                }
            }
            stack.pop();
        }
        return cnt;
    }
}
