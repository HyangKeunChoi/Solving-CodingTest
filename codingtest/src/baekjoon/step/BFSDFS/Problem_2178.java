package baekjoon.step.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// hard
// https://www.youtube.com/watch?v=2QVfsI55AVo
public class Problem_2178 {

    static int[][] matrix;
    private int n;
    private int m;
    static boolean[][] checked;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = br.readLine().split(" ");

        String N = splitLine[0];
        String M = splitLine[1];

        Problem_2178 problem_2178 = new Problem_2178();
        problem_2178.solution(N, M);

        matrix = new int[Integer.parseInt(N) + 1][Integer.parseInt(M) + 1];
        checked = new boolean[Integer.parseInt(N) + 1][Integer.parseInt(M) + 1];

        for (int i = 1; i <= Integer.parseInt(N); i++) {
            String read = br.readLine();

            String[] split = read.split("");
            for (int j = 1; j <= Integer.parseInt(M); j++) {
                matrix[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        problem_2178.bfs(1,1);
        System.out.println(matrix[Integer.parseInt(N)][Integer.parseInt(M)]);
    }

    private void solution(String n, String m) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
    }

    // 최단 거리 이므로 bfs
    private void bfs(int i, int j) {
        Queue<Integer> queueX = new LinkedList<>();
        queueX.offer(i);

        Queue<Integer> queueY = new LinkedList<>();
        queueY.offer(j);
        checked[i][j] = true;

        while (!queueX.isEmpty()) {

            int x = queueX.poll();
            int y = queueY.poll();

            for (int k = 0; k < 4; k++) {
                int tempX = x + dx[k];
                int tempY = y + dy[k];

                if (tempX >= 1 && tempY >= 1 && tempX <= n && tempY <= m) {
                    if (matrix[tempX][tempY] == 1 && checked[tempX][tempY] == false) {

                        queueX.offer(tempX);
                        queueY.offer(tempY);
                        checked[tempX][tempY] = true;
                        matrix[tempX][tempY] = matrix[x][y] + 1;
                    }
                }
            }
        }
    }
}
