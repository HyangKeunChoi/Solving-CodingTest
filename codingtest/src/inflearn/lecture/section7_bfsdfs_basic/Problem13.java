package inflearn.lecture.section7_bfsdfs_basic;

import java.util.ArrayList;
import java.util.Scanner;

// 경로탐색(인접리스트, ArrayList)
// 정점 개수 N이 너무 크면 메모리는 너무 낭비하게 된다
// ArrayList를 통해서 자기가 갈 수 있는 정점만 모아 놓는다

// 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지수를 출력하는 프로그램
public class Problem13 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) answer++;
        else {
            for(int nv : graph.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem13 T = new Problem13();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        for (int i=0; i<m; i++) {
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);

    }
}
