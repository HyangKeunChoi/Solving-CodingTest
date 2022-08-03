package inflearn.lecture.section9_greedy;

// 회의실 배정
// 회의를 최대한 많이 할 수 있는 경우 찾기

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 제일 빨리 끝나는거 선택-> 다음 회의 시작 시간 (단, 시작시간을 기준으로 오름 차순 정렬 해야함)
public class Problem_2 {

    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;

        Collections.sort(arr);
        int endTime = 0;
        for (Time ob: arr ) {
            if(ob.s >= endTime) {
                cnt++;
                endTime=ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Problem_2 problem_2 = new Problem_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(problem_2.solution(arr, n));
    }
}

class Time implements Comparable<Time> {
    public int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {

        // 끝나는 시간이 같으면 시작시간을 기준으로 오름차순 (음수가 되야 오름차순)
        if(this.e == o.e) return this.s-o.s;
        else return this.e-o.e;
    }
}