package inflearn.lecture.section1;

import java.util.ArrayList;
import java.util.Scanner;

// StringBuilder
public class Problem4 {

    public ArrayList<String> solution(int n, String[] str) {

        ArrayList<String> answer = new ArrayList<>();
        for(String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    // 가운데를 기준으로 char[]배열에서 위치 변경( 가운데를 기준으로 change)
    public ArrayList<String> solution1(int n, String[] str) {

        ArrayList<String> answer = new ArrayList<>();
        for(String x : str) {
            char[] s = x.toCharArray();
            int lt=0, rt= x.length()-1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = kb.next();
        }
        for (String x : problem4.solution(n, str)) {
            System.out.println(x);
        }
    }
}
