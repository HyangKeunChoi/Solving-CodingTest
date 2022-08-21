package baekjoon.step.withDayoung.week15;

import java.util.Arrays;
import java.util.Scanner;

// 암호만들기

// 조합 / 백트레킹
// https://velog.io/@ssojin
public class Problem_1759 {

    static int l, c;
    static char arr[];
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();
        arr = new char[c];
        visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);

        combination(0, 0);
    }

    static void combination(int start, int cnt) {
        if (cnt == l) {
            int v = 0;
            int cc = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c; i++) {
                if (visited[i]) {
                    sb.append(arr[i]);

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        v++;
                    } else {
                        cc++;
                    }
                }
            }
            if (v >= 1 && cc >= 2) System.out.println(sb);

        }
        //백트래킹
        for (int i = start; i < c; i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
