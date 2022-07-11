package inflearn.lecture.section3;

import java.util.Scanner;

public class Main {
        public String solution(String str){
            String answer="";
            int m=Integer.MIN_VALUE, pos;
            while((pos=str.indexOf(' '))!=-1){
                String tmp=str.substring(0, pos);
                int len=tmp.length();
                if(len>m){
                    m=len;
                    answer=tmp;
                }
                str=str.substring(pos+1);
            }
            if(str.length()>m) answer=str; // 마지막단어가 while문을 타지 않으므로 한번더 체크
            return answer;
        }

        public static void main(String[] args){
            Main T = new Main();
            Scanner kb = new Scanner(System.in);
            String str=kb.nextLine();
            System.out.print(T.solution(str));
        }
}

// indexOf에서 일치하는 단어 없으면 -1 리