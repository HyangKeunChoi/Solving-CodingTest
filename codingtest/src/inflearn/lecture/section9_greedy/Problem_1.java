package inflearn.lecture.section9_greedy;

// 그리디
// 씨름 선수

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 키로 정렬하고
// 몸무게로 for문 돌면 o(n)으로 끝낼 수 있다.
public class Problem_1 {
    public static void main(String[] args) {
        Problem_1 problem1 = new Problem_1();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }

        System.out.println(problem1.solution(arr, n));
    }

    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;

        // 내림차순 정렬
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body ob : arr) {
            if(ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }
}

class Body implements Comparable<Body> {
    public int h, w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }


    // 키로 내림차순정렬
    @Override
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}