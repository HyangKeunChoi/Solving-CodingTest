package programmers.withDayoung.week10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// https://www.youtube.com/watch?v=pF368QqdQb4

// 에라토스테네스의 체
// 소수 찾기
// 재귀를 통한 숫자 조합
public class Problem8 {

    Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        problem8.solution("17");
    }

    public int solution(String numbers) {
        int count = 0;

        // 만들 수 있는 숫자 조합하기(재귀)
        recursive("", numbers);
        System.out.println(numberSet); // 출력해 보기

        // 만든 숫자가 소수인지판단한다 - 에라토스테네스의 체 (특정 숫자의 루트값까지만 확인해서 소수인지 판별)
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int number) {
        // 1. 0과 1은 소수가 아니다.
        if (number == 0 || number == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit을 계산한다.
        int limit = (int) Math.sqrt(number); // root를 씌운값

        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        // set을 통한 만든 숫자 중복제거
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }
        // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
}
