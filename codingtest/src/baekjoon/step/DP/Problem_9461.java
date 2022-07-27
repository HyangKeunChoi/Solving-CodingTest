package baekjoon.step.DP;

import java.io.*;

public class Problem_9461 {

    static long[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Problem_9461 problem_9461 = new Problem_9461();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < input; i++) {
            int input2 = Integer.parseInt(br.readLine());
            dy = new long[input2 + 1];
            bw.write(String.valueOf(problem_9461.triangle(input2)));
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

    public long triangle(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        } else if (n == 4) {
            return 2;
        } else if (n == 5) {
            return 2;
        } else {
            dy[1] = 1;
            dy[2] = 1;
            dy[3] = 1;
            dy[4] = 2;
            dy[5] = 2;
        }

        for (int i = 6; i <= n; i++) {
            dy[i] = dy[i-5] + dy[i-1];
        }

        return dy[n];
    }

}
