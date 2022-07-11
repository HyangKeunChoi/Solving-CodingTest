package inflearn.whiteship.interview._01_array_02;

public class ReverseStringSelf {

    public static void main(String[] args) {
        ReverseStringSelf reverseString = new ReverseStringSelf();
        System.out.println(reverseString.solution("Hello".toCharArray()));
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     *  예) hello => olleh
     *  예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */
    private char[] solution(char[] message) {

        char[] reversedMessage = new char[message.length];

        for(int i= message.length -1 ; i >=0 ; i--) {
            reversedMessage[message.length -1 - i] = message[i];
        }

        return reversedMessage;
    }
}
