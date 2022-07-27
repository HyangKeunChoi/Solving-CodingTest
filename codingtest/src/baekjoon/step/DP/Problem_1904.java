package baekjoon.step.DP;

import java.io.*;

// 01타일
public class Problem_1904 {

    static int[] dy;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        Problem_1904 problem_1904 = new Problem_1904();
        dy = new int[input +1];

        bw.write(String.valueOf(problem_1904.fibo2(input)));
        bw.flush();
        bw.close();
    }


    public int fibo2(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;

        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = ( dy[i - 2] + dy[i - 1] ) % 15746;
        }
        return dy[n];
    }


}
