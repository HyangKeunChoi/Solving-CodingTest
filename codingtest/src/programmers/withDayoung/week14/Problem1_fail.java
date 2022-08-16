package programmers.withDayoung.week14;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/1829
// 카카오 프렌즈 컬러링 정복

// 테스트케이스 + 질문에 있는 테스트 다 통과하는떼.... 정답 solve가 안되네.............
public class Problem1_fail {

    static int count = 0;
    static ArrayList<Integer> area = new ArrayList<>();
    static int areaSize = 0;

    final static int MAX_SIZE=101;

    static int[] dx = {1,-1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int x = 0;
    static int y = 0;

    static int[][] matrix = new int[x][y];
    static Set set = new HashSet();

    static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];

    static int target = 0;
    static int max = 0;

    public static void main(String[] args) {
        Problem1_fail problem1 = new Problem1_fail();


        int[][] a = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};

        int[][] b = { {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
        //System.out.println(problem1.solution(6, 4, a));

        System.out.println(problem1.solution(13, 16, b));
    }

    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        x = m;
        y = n;
        area = new ArrayList<>();

        matrix = picture.clone();

        set = new HashSet();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != 0) {
                    set.add(matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                target = picture[i][j];
                if (set.contains(target) && visited[i][j] == false) {
                    count++; //분리된 영역의 개수
                    bfs(i, j);
                }
            }
        }

        //System.out.println(count);

        Collections.sort(area);
        for (int i = 0; i < area.size(); i++) {
            max = Math.max(max, area.get(i));
        }
        //System.out.println(max);
        int[] answer = new int[2];

        numberOfArea = count;
        maxSizeOfOneArea = max;
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static void bfs(int xx, int yy) {
        Queue<Node1> queue = new LinkedList<>();

        queue.offer(new Node1(xx, yy));
        visited[xx][yy] = true;

        areaSize = 0;
        while (!queue.isEmpty()) {

            Node1 node = queue.poll();

            areaSize++;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (matrix[nx][ny] == target && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        queue.offer(new Node1(nx, ny));
                    }
                }
            }
        }

        area.add(areaSize);
    }
}

class Node1 {
    int x;
    int y;

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
