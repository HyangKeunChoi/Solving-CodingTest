package inflearn.lecture.section6_sort;

// 장난 꾸러

// 철수와 짝궁이 바꾼 번호

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// arr[i] != temp[i]
public class Problem6 {

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        for (int x: problem6.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 깊은 복사
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) {
                answer.add(i+1);
            }
        }

        return answer;
    }
}
