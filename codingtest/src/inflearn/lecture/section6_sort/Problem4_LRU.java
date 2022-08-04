package inflearn.lecture.section6_sort;

import java.util.Scanner;

// LRU : Least Recently Used
// cache miss : 하나씩 오른쪽으로 옮기고 0번 인덱스에 추가
// cache hit : hit까지 오른쪽으로 옮기고 0번 인덱스에 추가
public class Problem4_LRU {

    public static void main(String[] args) {
        Problem4_LRU problem4_lru = new Problem4_LRU();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x :
                problem4_lru.solution(s, n, arr)) {
            System.out.println(x + " ");
        }
    }

    public int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];

        for (int x : arr) {
            int pos = -1; // 인덱스
            for (int i = 0; i < size; i++) {
                // hit
                if (x == cache[i]) {
                    pos = i;
                }
            }

            // miss인 상황
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;

            // hit일 때
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
                cache[0] = x;
            }
        }

        return cache;
    }

}
