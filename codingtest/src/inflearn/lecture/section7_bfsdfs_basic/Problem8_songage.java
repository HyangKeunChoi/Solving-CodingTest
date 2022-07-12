package inflearn.lecture.section7_bfsdfs_basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기 문제 (BFS)
public class Problem8_songage {

    int answer = 0; // 최소 횟수
    int[] move = {1, -1, 5};
    int[] ch; // 체크 배열, 한번 방문한거 체크
    Queue<Integer> queue = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10000]; // 좌표가 10000까지 이믐로
        ch[s] = 1;
        queue.offer(s);
        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for(int i=0; i<length; i++) {
                int x= queue.poll();

                // 답인지 체크 - 여기서 해도 되고 밑에서 해도 된다
                /*if(x == e) {
                    return level;
                }*/

                // move
                for(int j=0; j<3; j++) {
                    int nextX = x + move[j];

                    // 정답인지 체크
                    if(nextX == e) {
                        return level+1; // 자식노드니까
                    }

                    if(nextX >=1 && nextX<=10000 && ch[nextX]==0) {
                        ch[nextX] = 1;
                        queue.offer(nextX);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem8_songage T = new Problem8_songage();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }


}
