package baekjoon.step.DP;

import java.util.Scanner;

// 만취한 상범
// https://blog.naver.com/zzang9ha/221625305235
public class Problem_6359 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        double n;

        for(int i=1; i<=T; i++)
        {
            n = scan.nextInt();
            System.out.println((int)Math.sqrt(n));
        }
    }

}
