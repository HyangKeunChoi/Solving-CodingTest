package inflearn.lecture.section1;

import java.util.Scanner;

// indexOf, substring()
// 가장 긴단어 찾기
public class Problem3 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for (String s1 : s) {
            if ( m < s1.length() ) {
                m = s1.length();
                answer = s1;
            }
        }

        return answer;
    }

    // indexof  substring 사용하기
    public String solution1(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        // 띄어쓰기가 있을때 까지
        while((pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str= str.substring(pos+1);
            if(str.length()>m ) {
                answer = str;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem3 T = new Problem3();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
