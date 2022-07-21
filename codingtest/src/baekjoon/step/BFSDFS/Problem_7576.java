package baekjoon.step.BFSDFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 7576
public class Problem_7576 {
    static int matrix[][];
    static int w;
    static int h;
    static boolean checked[][];
    static int day = 1;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Integer> queue1 = new LinkedList();
    static Queue<Integer> queue2 = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        matrix = new int[h + 1][w + 1];
        checked = new boolean[h + 1][w + 1];

        for (int i = 1; i <= h; i++) {
            String read = br.readLine();
            String[] split = read.split(" ");
            for (int j = 1; j <= w; j++) {
                if (Integer.parseInt(split[j - 1]) == -1) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = Integer.parseInt(split[j - 1]);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i + 1][j + 1] == 1) {
                    queue1.offer(i + 1);
                    queue2.offer(j + 1);
                    checked[i + 1][j + 1] = true;
                }
            }
        }

        BFS();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                day = Math.max(day, matrix[i+1][j+1]);

                if (matrix[i + 1][j + 1] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (day == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(day - 1);
    }

    private static void BFS() {
        while (!queue1.isEmpty()) {
            int polli = queue1.poll();
            int pollj = queue2.poll();

            for (int k = 0; k < 4; k++) {
                int tempi = polli + dx[k];
                int tempj = pollj + dy[k];

                if (tempi <= h && tempj <= w && tempi > 0 && tempj > 0) {
                    if (!checked[tempi][tempj] && matrix[tempi][tempj] == 0) {
                        checked[tempi][tempj] = true;
                        matrix[tempi][tempj] = matrix[polli][pollj] + 1;
                        queue1.offer(tempi);
                        queue2.offer(tempj);
                    }
                }
            }
        }
    }
}
