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

    static Queue<Tomato> queue = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
                    queue.offer(new Tomato(i+1, j+1));
                    checked[i + 1][j + 1] = true;
                }
            }
        }

        BFS();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                day = Math.max(day, matrix[i+1][j+1]);

                // 0이 하나라도 있으면
                if (matrix[i + 1][j + 1] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.close();
                    return;
                }
            }
        }

        // 모두 1일이면
        if (day == 1) {
            bw.write(String.valueOf(0));
            bw.close();
            return;
        }

        bw.write(String.valueOf(day - 1));
        bw.close();
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int k = 0; k < 4; k++) {
                int tempi = tomato.x + dx[k];
                int tempj = tomato.y + dy[k];

                if (tempi <= h && tempj <= w && tempi > 0 && tempj > 0) {
                    if (!checked[tempi][tempj] && matrix[tempi][tempj] == 0) {
                        checked[tempi][tempj] = true;
                        matrix[tempi][tempj] = matrix[tomato.x][tomato.y] + 1;
                        queue.offer(new Tomato(tempi, tempj));
                    }
                }
            }
        }
    }
}

class Tomato{
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}