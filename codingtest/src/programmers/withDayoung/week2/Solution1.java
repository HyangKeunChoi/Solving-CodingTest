package programmers.withDayoung.week2;

/*
 * 2021 카카오 채용연계형 인턴십 > 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Solution1 {
    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution("one4seveneight"));
        System.out.println(solution1.solution("23four5six7"));
        System.out.println(solution1.solution("2three45sixseven"));
        System.out.println(solution1.solution("123"));
    }

    public int solution(String s) {

        if (isContain(s, "zero")) {
            s = s.replaceAll("zero", "0");
        }
        if (isContain(s, "one")) {
            s = s.replaceAll("one", "1");
        }
        if (isContain(s, "two")) {
            s = s.replaceAll("two", "2");
        }
        if (isContain(s, "three")) {
            s = s.replaceAll("three", "3");
        }
        if (isContain(s, "four")) {
            s = s.replaceAll("four", "4");
        }
        if (isContain(s, "five")) {
            s = s.replaceAll("five", "5");
        }
        if (isContain(s, "six")) {
            s = s.replaceAll("six", "6");
        }
        if (isContain(s, "seven")) {
            s = s.replaceAll("seven", "7");
        }
        if (isContain(s, "eight")) {
            s = s.replaceAll("eight", "8");
        }
        if (isContain(s, "nine")) {
            s = s.replaceAll("nine", "9");
        }
        return Integer.parseInt(s);
    }

    private boolean isContain(String s, String number) {
        return s.contains(number);
    }
}
