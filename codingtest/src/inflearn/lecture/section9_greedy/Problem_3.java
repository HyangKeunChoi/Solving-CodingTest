package inflearn.lecture.section9_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 결혼식
public class Problem_3 {

    public static void main(String[] args) {
        Problem_3 problem3 = new Problem_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time2> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Time2(st, 's'));
            arr.add(new Time2(et, 'e'));
        }
        System.out.println(problem3.solution(arr));
    }

    public int solution(ArrayList<Time2> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time2 ob: arr) {
            if(ob.state == 's') cnt++;
            else cnt --;

            answer= Math.max(answer, cnt);
        }

        return answer;
    }
}

class Time2 implements Comparable<Time2> {
    public int time;
    public char state;

    public Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }

    // 시간으로 정렬하는데 시간이 같으면 e가 먼저 나온다.
    @Override
    public int compareTo(Time2 ob) {
        if(this.time==ob.time) return this.state-ob.state;
        else return this.time-ob.time;
    }
}