package baekjoon.step.withDayoung.week12;

import java.io.*;

// Four Squres
// DP
// https://loosie.tistory.com/229
public class Problem_17626 {
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        solve(n);
        System.out.println(dp[n]);
    }

    static void solve(int n) {
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                // 이부분을 이해하기 어려움....
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
    }
}
