package inflearn.lecture.section1.problem1;

import java.util.Scanner;

public class Main{
    public int solution(String str, char t){ // static으로해서 객체 생성 안해도 된다
        int answer=0;
        str=str.toUpperCase();
        t=Character.toUpperCase(t);
        //System.out.println(str+" "+t);
		/*for(int i=0; i<str.length(); i++){
			if(str.charAt(i)==t) answer++;
		}*/
        for(char x : str.toCharArray()){
            if(x==t) answer++; // 문자는 ==비교가 되네??
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next(); // 문자열 하나 읽어들인다.
        char c=kb.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}

// 1. 문자열 읽어 들이는 방법  sc.next()
// 2. Character.toUpperCase()
// 3. 문자비교는 == 이 가능하다.
// 4. String.toCharArray()