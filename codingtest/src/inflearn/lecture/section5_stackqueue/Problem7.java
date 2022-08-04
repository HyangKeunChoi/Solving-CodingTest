package inflearn.lecture.section5_stackqueue;

// 교육과정 설계 (queue)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 필수 과목이 있고 , 그 순서가 유지 되어야 한다.
// 잘짰으면 YES, 잘못 짰으면 NO
public class Problem7 {

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        System.out.println(problem7);


    }

    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        // queue에 필수 과목 세팅
        for(char x : need.toCharArray()) {
            q.offer(x);
        }

        for(char x : plan.toCharArray()) {
            // 필수 과목이라면
            if(q.contains(x)) {
                if(x!=q.poll()) {
                    return "NO";
                }
            }
        }

        if(!q.isEmpty()) {
            return "NO";
        }

        return answer;
    }



}
