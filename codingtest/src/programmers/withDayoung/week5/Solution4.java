package programmers.withDayoung.week5;

import java.util.Arrays;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.solution("001112255"));
        // System.out.println(solution4.solution("0011"));
    }

    public String solution(String phone_number) {

        String first = phone_number.substring(0, phone_number.length() - 4);
        String last = phone_number.substring(phone_number.length() - 4, phone_number.length());

        // StringBuffer sb = new StringBuffer();
        // sb.append(first.replaceAll("[0-9]", "*")).append(last);
        // return sb.toString();

        // TODO :  스트림으로 바꿔보자
        StringBuffer sb2 = new StringBuffer();

        String[] arr = Arrays.stream(phone_number.split("")).limit(phone_number.length() - 4)
                .map(i -> i.replaceAll("[0-9]", "*")).toArray(String[]::new);

        for (String s : arr) {
            sb2.append(s);
        }
        sb2.append(last);

        return sb2.toString();
    }

}
