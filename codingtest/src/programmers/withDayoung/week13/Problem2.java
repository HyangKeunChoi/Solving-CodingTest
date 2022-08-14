package programmers.withDayoung.week13;

import java.util.Arrays;
import java.util.Comparator;

// https://st-lab.tistory.com/243
// 가장 큰 수
public class Problem2 {

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();

        int[] arr = {1, 91, 9 , 4 , 3 };
        System.out.println(problem2.solution(arr));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];

        for(int i = 0; i< numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 음수일 경우 : 두 원소의 위치를 교환 안함
        // 양수일 경우 : 두 원소의 위치를 교환 함

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        // 이렇게도  비교
        /*Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(0) == b.charAt(0)){
                    int aa = Integer.parseInt(a+b);
                    int bb = Integer.parseInt(b+a);
                    return bb - aa;
                }

                return b.charAt(0) - a.charAt(0);
            }
        });*/

        if(str[0].equals("0")) {
            return "0";
        }

        for(String s : str) {
            answer += s;
        }

        return answer;
    }
}
