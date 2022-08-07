package programmers.withDayoung.week12;

// 2021 kakao blind
// 신규 아이디 추천

// 풀이
// https://zzang9ha.tistory.com/322

// https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C-java-2021-KAKAO-BLIND-RECRUITMENT
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        //System.out.println(problem1.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(problem1.solution("z-+.^."));
    }

    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        // \\-_. 에서 -_. 순서도 중요하다
        answer = answer.replaceAll("[^a-z\\-_.0-9]", "");

        // .. 연속2개면 .으로 교체
        answer = answer.replaceAll("\\.{2,}", ".");

        // .으로 시작하거나 .으로 끝나면 공백으로 교체
        answer = answer.replaceAll("^[.]|[.]$", "");

        if ("".equals(answer)) {
            answer = "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        answer = answer.replaceAll("[.]$", "");

        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

}
