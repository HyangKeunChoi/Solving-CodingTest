package baekjoon.step.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

// 일곱 난쟁이
// https://www.acmicpc.net/problem/2309
public class Problem_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleNum = 9;
        int[] arr = new int[peopleNum];
        int sum = 0;
        for (int i = 0; i < peopleNum; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        for (int i = 0; i < peopleNum; i++) {
            for (int j = i + 1; j < peopleNum; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    // 출력
                    for (int k = 0; k < peopleNum; k++) {
                        if (i == k || j == k) continue;
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
