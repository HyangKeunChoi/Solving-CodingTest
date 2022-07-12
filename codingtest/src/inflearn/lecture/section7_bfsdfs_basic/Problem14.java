package inflearn.lecture.section7_bfsdfs_basic;

// 최단거리는 BFS라고 생각하자
// 1번 정점에서 각 정점으로 가는 최소 이동 간선

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 레벨보단 배열로 해보기
// 1번 정점에서 다음 정점까지 가는 최단거리수를 가진 배열
// dis[nextVertx] = dis[vertex] + 1
public class Problem14 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v]=1;
        dis[v]=0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int currentVertex= queue.poll();
            for(int nv : graph.get(currentVertex)) {
                if(ch[nv] == 0) {
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv] = dis[currentVertex] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem14 problem14 = new Problem14();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 정점의 개수
        m = kb.nextInt(); // 간선의 개수
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for ( int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        problem14.BFS(1);
    }
}
