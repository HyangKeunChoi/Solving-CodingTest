package inflearn.lecture.section3;

import java.util.Arrays;
import java.util.Scanner;

public class FindLongWords {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        String[] splitString = input.split(" ");


        FindLongWords findLongWords = new FindLongWords();
        System.out.println(findLongWords.solution(splitString));
    }

    String solution(String[] str) {
        int max = Integer.MIN_VALUE;
        // loop 돌면서 count해야 되나???
        String answer = "";
        for (String s : str) {
            if(s.length() > max) { // s.length() >= max 가되면 같은 길이의 뒤에 단어가 정답이 되어버린다.
                max = s.length();
                answer = s;
            }
        }

        return answer;
    }
}

// 1. String input = in.nextLine() 으로 받아야함 next()로 받으면 안됌
// next()는 공백을 기준으로 한단어 또는 한문자 / nextLine()은 문자 또는 문장 전체

// 2. String[] 배열은 String으로 foreach돌릴 수 있다.