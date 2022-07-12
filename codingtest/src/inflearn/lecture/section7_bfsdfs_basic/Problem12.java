package inflearn.lecture.section7_bfsdfs_basic;

import java.util.Scanner;

// 경로 탐색(인접행렬)
// 그래프에서 경로는 다시 방문하지 않는다.
// DFS

// hard
// 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성
public class Problem12 {

    static int n, m , answer =0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        if(v==n) answer++;
        else {
            for( int i=1; i<=n; i++) {
                if(graph[v][i] == 1 && ch[i] ==0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0; // 체크를 푼다
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n+1][m+1];
        ch = new int[n+1];

        // 몇번에서 몇번으로 가는지 입력 받는다
        for (int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1; // 출발점 체크
        problem12.DFS(1);
        System.out.println(answer);
    }

}
