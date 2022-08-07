package baekjoon.step.withDayoung.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 영역 구하기
// https://www.acmicpc.net/problem/2583

// 어디서 count하는지 중요한 문제!!!

public class Problem_2583 {

    static int[][] matrix;
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int count = 0;
    static int cnt = 0; // 너비
    static int x;
    static int y;

    static ArrayList<Integer> area = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        matrix = new int[x][y];
        visit = new boolean[x][y];

        for (int i = 0; i < z; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int a = x1; a < x2; a++) {
                for (int b = y1; b < y2; b++) {
                    matrix[b][a] = 1;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visit[i][j] && matrix[i][j] == 0) {
                    count++; // 개수
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        Collections.sort(area);
        for (int i = 0; i < area.size(); i++) {
            if(area.size() !=0 ) System.out.print(area.get(i) + " ");
            else System.out.print(0);
        }
    }

    static void bfs(int xx, int yy) {
        Queue<Node> queue = new LinkedList<>();

        visit[xx][yy] = true;
        queue.offer(new Node(xx, yy));

        cnt = 0;
        while (!queue.isEmpty()) {

            Node node = queue.poll();

            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (!visit[nx][ny]  && matrix[nx][ny] == 0) {
                        visit[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

        area.add(cnt);
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}