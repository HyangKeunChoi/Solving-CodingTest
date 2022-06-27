package programmers.withDayoung.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
 * 정수 내림차순으로 배치하기
 * 역순 정렬하기
 */
public class Solution3_ReverseOrdr {
    public static void main(String[] args) {
        Solution3_ReverseOrdr solution3 = new Solution3_ReverseOrdr();
        System.out.println(solution3.solution(8134512));
    }
    public long solution(long n) {
        // long to string
        String s = String.valueOf(n);

        // string to string Array
        String[] strArr = s.split("");

        strArr = Arrays.stream(strArr).sorted(Comparator.reverseOrder())
                .toArray(String[]::new);

        // string array to string
        String str = String.join(",", strArr);

        return Long.parseLong(str.replaceAll(",", ""));
    }
}
