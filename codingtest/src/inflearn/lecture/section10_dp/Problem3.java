package inflearn.lecture.section10_dp;

// 부분 증가 수열 - 순서를 유지하면서 , 숫자 빼서, 오름차순을 만족

import java.util.Scanner;

// 최장 증가 부분 수열(LIS) 알고리즘
// dy[i] - i를 마지막으로 하면서 만들 수 있는 최대 증가 부분 수열
public class Problem3 {
    static int[] dy;
    public int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];

        dy[0] =1; // 그냥 초기화
        for (int i = 1; i < arr.length; i++) {
            int max =0;
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i]=max+1;
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(problem3.solution(arr));
    }


}
