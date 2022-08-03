package inflearn.lecture.section6_sort;

// 삽입 정렬

import java.util.Scanner;

// 2중 포문
// j는 i-1부터 0 인덱스 까지
// temp는 arr[i]
public class Problem3_insertSort {

    public static void main(String[] args) {
        Problem3_insertSort problem3_insertSort  = new Problem3_insertSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x :
                problem3_insertSort.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }

    public int[] solution(int n, int[] arr) {

        // i는 1부터
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }

        return arr;
    }
}
