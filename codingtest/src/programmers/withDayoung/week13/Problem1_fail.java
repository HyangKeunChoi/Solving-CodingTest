package programmers.withDayoung.week13;

import java.util.PriorityQueue;

// 프린터
// 45프로 성공 코드 priorityQueue를 이용
public class Problem1_fail {

    public static void main(String[] args) {
        Problem1_fail problem1 = new Problem1_fail();
        int[] priorities = {1, 2, 8, 3, 4};
        int location = 4;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(problem1.solution(priorities, location));
        //System.out.println(problem1.solution(priorities2, location2));
    }

    public int solution(int[] priorities, int location) {

        int findLocation = location;
        int max = Integer.MIN_VALUE;
        // int changeCnt = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < priorities.length; i++) {
            if(max < priorities[i]) {
                max = priorities[i];
            }
            queue.offer(new Node(i, priorities[i]));
        }

        for (int i = 0; i < queue.size(); i++) {
            if(queue.peek().value != max) {
                queue.offer(queue.poll());
                // changeCnt++;
            }
        }

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            if(queue.peek().index == findLocation) {
                return i + 1;
            } else {
                queue.poll();
            }
        }

        return 0;
    }
}

class Node implements Comparable<Node>{
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return o.value - this.value;
    }
}
