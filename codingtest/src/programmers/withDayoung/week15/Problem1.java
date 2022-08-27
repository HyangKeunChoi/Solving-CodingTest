package programmers.withDayoung.week15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// H-index
// https://www.youtube.com/watch?v=6Hh-sR8PYo4
public class Problem1 {

    public static void main(String[] args) {

        Problem1 problem1 = new Problem1();

        int[] a = {3, 0, 6, 1, 5};

        int[] b = {1000, 1000};
        System.out.println(problem1.solution(a));
        System.out.println(problem1.solution(b));
    }

    public int solution(int[] citations) {
        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length-i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
