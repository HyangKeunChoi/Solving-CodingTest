package programmers.withDayoung.week10;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// 게임 맵 최단 거리
public class Problem5 {

    static boolean[][] checked;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};


    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();


        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},
                {1,1,1,0,1},{0,0,0,0,1}};


        System.out.println(problem5.solution(arr));
    }

    public int solution(int[][] maps) {
        checked = new boolean[maps.length][maps[0].length];

        Queue<Integer> queueX = new LinkedList<>();
        queueX.offer(0);
        Queue<Integer> queueY = new LinkedList<>();
        queueY.offer(0);
        checked[0][0] = true;

        while (!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            for (int k = 0; k < 4; k++) {
                int tempX = x + dx[k];
                int tempY = y + dy[k];

                if (tempX >= 0 && tempY >= 0 && tempX < maps.length && tempY < maps[0].length) {
                    if (maps[tempX][tempY] == 1 && checked[tempX][tempY] == false) {

                        queueX.offer(tempX);
                        queueY.offer(tempY);
                        checked[tempX][tempY] = true;
                        maps[tempX][tempY] = maps[x][y] + 1;
                    }
                }
            }
        }

        if(maps[maps.length-1][maps[0].length-1] == 1) {
            return -1;
        } else {
            return maps[maps.length - 1][maps[0].length - 1];
        }
    }
}
