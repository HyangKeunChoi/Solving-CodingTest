package baekjoon.step.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_2667 {

    static int matrix[][];
    static int w;
    static boolean checked[][];
    static int count;

    static int[] dx = {1, 0,-1, 0};
    static int[] dy = {0, 1, 0, -1};

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());


        matrix = new int[w + 1][w + 1];
        checked = new boolean[w + 1][w + 1];

        for (int i = 0; i < w; i++) {
            String[] numArr = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                matrix[i + 1][j + 1] = Integer.parseInt(numArr[j]);
            }
        }

        // BFS();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                count = 0;
                if (matrix[i + 1][j + 1] == 1 && !checked[i + 1][j + 1]) {
                    checked[i + 1][j + 1] = true;
                    count++;
                    BFS(i + 1, j + 1);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
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

            for (int k = 0; k < 4; k++) {
                int tempi = polli + dx[k];
                int tempj = pollj + dy[k];

                if (tempi <= w && tempj <= w && tempi > 0 && tempj > 0) {
                    if (!checked[tempi][tempj] && matrix[tempi][tempj] == 1) {
                        checked[tempi][tempj] = true;
                        queue1.offer(tempi);
                        queue2.offer(tempj);
                        count++;
                    }
                }
            }
        }
        list.add(count);

    }
}
