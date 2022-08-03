package inflearn.lecture.section6_sort;

// 선택 정렬

// i가 0일때 j는 1부터 끝까지
// i가 1일때 j는 2부터 끝까지

import java.util.Scanner;

// 2중 포문

// 이게 더 깔끔한듯??
// https://wakestand.tistory.com/596
public class Problem1_selectionSort {

    public static void main(String[] args) {
        Problem1_selectionSort problem1SelectionSort = new Problem1_selectionSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : problem1SelectionSort.solution(n, arr)) {
            System.out.println(x + " ");
        }

    }

    public int[] solution(int n, int[] arr) {

        // 맨마지막 n의 한 단계 전인 n-1까지만 루프 돌아도 된다.
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

}
