package baekjoon.step.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준
// 섬의 개수
public class Problem_4963 {

    static int matrix[][];
    static int w;
    static int h;
    static boolean checked[][];
    static int count;

    static int[] dx = {1, 0,-1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1,1, -1, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        while (true) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h ==0 ) {
                System.exit(0);
            }

            matrix = new int[h + 1][w + 1];
            checked = new boolean[h + 1][w + 1];

            for (int i = 0; i < h; i++) {
                String[] numArr = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    matrix[i + 1][j + 1] = Integer.parseInt(numArr[j]);
                }
            }

            // BFS();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (matrix[i + 1][j + 1] == 1 && !checked[i + 1][j + 1]) {
                        checked[i + 1][j + 1] = true;
                        BFS(i + 1, j + 1);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void BFS(int i, int j) {

        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();

        queue1.offer(i);
        queue2.offer(j);

        while(!queue1.isEmpty()) {

            int polli = queue1.poll();
            int pollj = queue2.poll();

            for (int k = 0; k < 8; k++) {
                int tempi = polli + dx[k];
                int tempj = pollj + dy[k];

                if (tempi <= h && tempj <= w && tempi > 0 && tempj > 0) {
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
