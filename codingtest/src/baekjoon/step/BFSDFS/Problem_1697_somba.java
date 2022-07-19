package baekjoon.step.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1697  숨바꼭질
// https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88
public class Problem_1697_somba {

    static int[] dx = {-1, 0, 1};
    static int[] dy = {0, 2, 0};
    static int[] checked = new int[100001];
    ;
    static int j;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());

        BFS(i);
    }

    private static void BFS(int i) {

        Queue<Integer> queue = new LinkedList();
        queue.offer(i);
        checked[i] = 1;

        while (!queue.isEmpty()) {
            int tempx = queue.poll();
            for (int k = 0; k < 3; k++) {
                int next;

                if (k == 1) {
                    next = tempx * dy[k];
                } else {
                    next = tempx + dx[k];
                }

                if (next == j) {
                    System.out.println(checked[tempx]);
                    return;
                } else if (next >= 0 && next <= 100000 && checked[next] == 0) {
                    queue.offer(next);
                    checked[next] = checked[tempx] + 1;
                }
            }
        }
    }
}
