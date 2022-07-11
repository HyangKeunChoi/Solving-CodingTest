package inflearn.lecture.section1.problem1;

import java.util.Scanner;

public class Findmessage1 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String[] strArr = input1.split("");
        char input2 = in.next().charAt(0);

        Findmessage1 findmessage1 = new Findmessage1();
        System.out.println(findmessage1.solution(strArr, input2));



    }

    public int solution(String[] input1, char input2) {

        int answer = 0;
        for (int i=0; i<=input1.length -1; i++) {
            if ((String.valueOf(input2).toUpperCase()).equals(input1[i].toUpperCase())) {
                ++answer;
            }
        }

        return answer;

    }
}
