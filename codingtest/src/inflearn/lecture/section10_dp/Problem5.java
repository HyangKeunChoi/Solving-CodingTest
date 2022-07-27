package inflearn.lecture.section10_dp;

import java.util.Arrays;
import java.util.Scanner;

// hard
// 동전교환(냅색 알고리즘) knapsack
// DFS로 풀수있는데 n이 커지면 타임아웃나니까 dp로
public class Problem5 {

    // dy[i] : i 금액을 만드는데 드는 최소 동전 개수

    // dy[j - coin[i]] +1

    static int n,m;
    static int[] dy;
    public int solution(int[] coin) {

        // 초기화
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] =0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]] +1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt();
        dy = new int[m+1];
        System.out.println(problem5.solution(arr));
    }
}
