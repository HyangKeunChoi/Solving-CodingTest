package inflearn.whiteship.interview._01_array_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateSolutions {
    
    public static void main(String[] args) {
        ContainsDuplicateSolutions containsDuplicate = new ContainsDuplicateSolutions();
        System.out.println(containsDuplicate.solution3(new int[] {1, 2, 3, 4, 5}));
    }
    
    // 배열문제는 정렬이 되어 있는지 먼저 확인한다
    private boolean solution1(int[] numbers) {
        for (int i = 0 ; i < numbers.length ; i++) {
            for (int j = i + 1 ; j < numbers.length ; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solution2(int[] numbers) {
        Arrays.sort(numbers); // 정렬  시간 : O(NlogN), 공간 : O(logN)

        // 알고리즘은 시간과 공간 복잡도가 trade-off 관계이다.
        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }

        return false;
    }

    // Set은 해시값으로 조회를 하기 때문에 조회가 O(1)
    // Set의 contains O(1)
    private boolean solution3(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : numbers) {
            if (numberSet.contains(num)) {
                return true;
            } else {
                numberSet.add(num);
            }
        }

        return false;
    }

}
