package inflearn.lecture.section5_stackqueue;

// 공주 구하기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1 2 빼서 뒤로 넣고 3 poll
// 4 5 빼서 뒤로 넣고 6 poll
public class Problem6_princess {

    public static void main(String[] args) {
        Problem6_princess problem6_princess = new Problem6_princess();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(problem6_princess.solution(n, k));
    }

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();

            if(q.size() == 1) {
                answer=q.poll();
            }
        }

        return answer;

    }
}
