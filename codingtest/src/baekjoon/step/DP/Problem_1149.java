package baekjoon.step.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리 실패
// FAIL
// d[1] = 가장 작은거
// d[2] = d[1]색을 제외한 가장 작은거
// d[3] = 가장 작은거
// d[4] = 2와 3에서 칠하지 않은 색상
// ..... 이떄부터는 고정된 색

// 이렇게 풀었음
// https://www.youtube.com/watch?v=QGsmvwCIAks
public class Problem_1149 {

    static int[] dy;
    static int[] dx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int answer = 0;
        dy = new int[input + 1];
        dx = new int[input + 1];

        for (int i = 1; i <= input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            if (i == 1) {
                dy[1] = Math.min(red, Math.min(green, blue));

                if(dy[1] == red) {
                    dx[1] = 1;
                } else if(dy[2] == green) {
                    dx[1] = 2;
                } else {
                    dx[1] = 3;
                }

                answer += dy[1];

            } else if (i == 2){
                if(dx[1] == 1) {
                    dy[2] = Math.min(green, blue);
                    if(Math.min(green, blue) == green) {
                        dx[2] = 2;
                    } else {
                        dx[2] = 3;
                    }
                } else if (dx[2] == 2) {
                    dy[2] = Math.min(red, blue);
                    if(Math.min(red, blue) == red) {
                        dx[2] = 1;
                    } else {
                        dx[2] = 3;
                    }
                } else {
                    dy[2] = Math.min(red, green);
                    if(Math.min(red, green) == red) {
                        dx[2] = 1;
                    } else {
                        dx[2] = 2;
                    }
                }

                answer += dy[2];

            } else if (i == 3) {
                int prev2 = dx[1];
                int preve = dx[2];

                int value = (input * 2) - preve - prev2;
                if(value == 1) {
                    dy[3] = red;
                } else if(value == 2) {
                    dy[3] = green;
                } else {
                    dy[3] = blue;
                }

                answer += dy[3];

            } else {
                int prev2 = dx[i-2];
                int preve = dx[i-1];

                int value = (input * 2) - preve - prev2;

                if(value == 1) {
                    dy[i] = red;
                } else if(value == 2) {
                    dy[i] = green;
                } else {
                    dy[i] = blue;
                }
                answer += dy[i];

            }
        }
        System.out.println(answer);

    }

}
