package programmers.self.beginner;

public class StringRepeatPrint {

    public static void main(String[] args) {

    }

    public String solution(String my_string, int n) {
        String answer = "";

        for (char s: my_string.toCharArray()) {
            for (int i = 0; i < n; i++) {
                answer += s;
            }
        }

        return answer;
    }
}
