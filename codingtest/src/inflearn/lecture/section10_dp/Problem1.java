package inflearn.lecture.section10_dp;

import java.util.Scanner;

// 계단 오르기
// 계단 오르는 경우의 수 구하기
public class Problem1 {

    static int[] dy;
    public int solution(int n) {

        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++) {
            dy[i]=dy[i-2] + dy[i-1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+1];
        System.out.println(problem1.solution(n));
    }
}
