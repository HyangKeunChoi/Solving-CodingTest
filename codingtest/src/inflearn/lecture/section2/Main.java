package inflearn.lecture.section2;

import java.util.Scanner;

public class Main {
    public StringBuffer solution(String str){
        StringBuffer answer = new StringBuffer();
        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x)) answer.append(Character.toUpperCase(x));
            else answer.append(Character.toLowerCase(x));

        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}

// 1. isLowerCase  - true/false