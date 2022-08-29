package programmers.withDayoung.week15;

import java.util.Arrays;

// 전화번호 목록 (해시)
// https://www.youtube.com/watch?v=ggoKE9FQIEQ&t=3s
public class Problem2 {

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();

        String[] p = {"119", "97674223", "1195524421"};

        String[] p2 = {"11993","119", "97674223", "1195524421"};

        // System.out.println(problem2.solution(p));
        System.out.println(problem2.solution(p2));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 문자열 정렬시 119, 1195524421, 11993, 97674223 순으로 정렬된다
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length; i++){
            if(i == phone_book.length -1) break;
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
