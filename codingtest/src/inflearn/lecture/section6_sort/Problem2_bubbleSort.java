package inflearn.lecture.section6_sort;

// 버블 정렬

import java.util.Scanner;

// 한번의 턴으로 맨 뒷자리 숫자를 구할 수 있다.
// 맨 마지막 자리 순서대로 결정된다.
public class Problem2_bubbleSort {

    public static void main(String[] args) {
        Problem2_bubbleSort problem2_bubbleSort = new Problem2_bubbleSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : problem2_bubbleSort.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }

    public int[] solution(int n, int[] arr) {

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }


}
