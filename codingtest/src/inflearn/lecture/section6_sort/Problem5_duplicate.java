package inflearn.lecture.section6_sort;

// 중복확인
// 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D
// N명이 모두 각자 다른 숫자를 적어냈다면 U

// 정렬로 풀수있다는 걸 알려주기 위해서

import java.util.Arrays;
import java.util.Scanner;

// hashmap - o(n)
// 정렬 - nlogn
public class Problem5_duplicate {

    public static void main(String[] args) {
        Problem5_duplicate problem_5_duplicate = new Problem5_duplicate();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem_5_duplicate.solution(n, arr));


    }

    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] == arr[i+1]) {
                return "D";
            }
        }
        return answer;
    }
}
