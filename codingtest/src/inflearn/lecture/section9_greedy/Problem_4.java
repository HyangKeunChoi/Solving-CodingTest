package inflearn.lecture.section9_greedy;

// 최대수입스케줄
// 우선순위 큐 - PriorityQueue

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// D일 안에 오기만 하면 된다.
public class Problem_4 {

    static int n;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) {

        Problem_4 problem_4 = new Problem_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }

    }

    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;

        // 큰값을 우선순위로 하는 priorityQueue
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j= 0;

        // 날짜 감소 : 예) 3일 -> 2일 -> 1일
        for (int i = max; i >= 1; i--) {
            for ( ; j < n;  j++) {
                if(arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }
        if(!pQ.isEmpty()) answer+=pQ.poll();// 가장 큰값을 poll한다.
        }

        return answer;
    }

}

class Lecture implements Comparable<Lecture> {
    public int money;
    public int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.time-this.time;
    }
}