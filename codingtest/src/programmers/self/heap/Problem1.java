package programmers.self.heap;

import java.util.PriorityQueue;

// 힙 ( 우선순위 큐)
// 더 맵게
public class Problem1 {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for (int a : scoville) {
            queue.offer(a);
        }

        while (queue.peek() < K) {

            if (queue.size() == 1 && queue.peek() < K) {
                return -1;
            }

            int first = queue.poll();
            int second = queue.poll();
            queue.offer(first + (second * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem1 problem2 = new Problem1();

        //int[] arr = {1, 2, 3, 9, 10, 12};

        int[] arr2 = {1, 2};
        int K = 7;
        System.out.println(problem2.solution(arr2, K));
    }


}
