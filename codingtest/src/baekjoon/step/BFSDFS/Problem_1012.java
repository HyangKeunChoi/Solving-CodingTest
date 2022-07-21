package baekjoon.step.BFSDFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
// BufferedWriter int형 숫자 출력
public class Problem_1012 {

    static int matrix[][];
    static int w;
    static int h;
    static int v;
    static boolean checked[][];
    static int wormCount;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (count > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            matrix = new int[w + 1][h + 1];
            checked = new boolean[w + 1][h + 1];

            for (int a = 0; a < v; a++) {
                String[] numArr = br.readLine().split(" ");
                matrix[Integer.parseInt(numArr[0]) + 1][Integer.parseInt(numArr[1]) + 1] = 1;
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (matrix[i + 1][j + 1] == 1 && !checked[i + 1][j + 1]) {
                        checked[i + 1][j + 1] = true;
                        wormCount++;
                        BFS(i + 1, j + 1);
                    }
                }
            }

            // int형 숫자 출력
            bw.write(String.valueOf(wormCount));
            bw.newLine();

            wormCount = 0;
            count--;
        }

        bw.flush();
        bw.close();
    }

    private static void BFS(int i, int j) {
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();

        queue1.offer(i);
        queue2.offer(j);

        while (!queue1.isEmpty()) {
            int polli = queue1.poll();
            int pollj = queue2.poll();

            for (int k = 0; k < 4; k++) {
                int tempi = polli + dx[k];
                int tempj = pollj + dy[k];

                if (tempi <= w && tempj <= h && tempi > 0 && tempj > 0) {
                    if (!checked[tempi][tempj] && matrix[tempi][tempj] == 1) {
                        checked[tempi][tempj] = true;
                        queue1.offer(tempi);
                        queue2.offer(tempj);
                    }
                }
            }
        }
    }
}
