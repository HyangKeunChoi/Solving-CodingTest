package baekjoon.step.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/24416
// 피보나치의 수
public class Problem_24416 {

    static int[] dy = new int[41];
    static int count1;
    static int count2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        Problem_24416 problem_24416 = new Problem_24416();

        problem_24416.fibo1(input);
        System.out.print(count1 + " ");
        System.out.print(problem_24416.fibo2(input));
    }

    public int fibo1(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return fibo1(n - 1) + fibo1(n - 2);
        }
    }

    public int fibo2(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            count2++;
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return count2;
    }
}
