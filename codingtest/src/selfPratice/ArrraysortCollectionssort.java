package selfPratice;

import java.util.Arrays;
import java.util.Collections;

// https://sabarada.tistory.com/138
// array sort와 collection sort 차이
// 참고) list sort에 대해서도 알아보자
public class ArrraysortCollectionssort {

    public static void main(String[] args) {

        int[] array = new int[]{5, 2, 1, 4, 3};

        // Arrays.sort는 기본형, 참조형 가능
        // DualPivotQuickSort  알고리즘
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        // Collections.sort는 참조형만 가능
        // 즉 int[] 배열은 정렬이 안됌
        // TimSort 알고리즘
        String[] arrays = new String[]{"5", "2", "1", "4", "3" };

        Collections.sort(Arrays.asList(arrays));
        for (String s : arrays) {
            System.out.print(s + " ");
        }
    }
}
