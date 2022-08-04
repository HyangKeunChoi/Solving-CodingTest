package inflearn.lecture.section6_sort;

// 이분검색(이분탐색)
// 이분검색은 무조건 정렬 되어 있어야 한다.

import java.util.Arrays;
import java.util.Scanner;

// 임의의 N개 숫자가 입력으로 주어진다.
// 오름차순으로 정렬  N개의 수 중 한개인 M이 정렬된 상태에서 몇 번째에 있는지
public class Problem8_binarySearch {

    public static void main(String[] args) {
        Problem8_binarySearch  problem8_binarySearch = new Problem8_binarySearch();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem8_binarySearch.solution(n, m, arr));

    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        // 정렬
        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;
        while(lt<=rt) {
            int mid = (lt+rt) / 2;

            // 정답인 경우
            if(arr[mid] == m) {
                answer= mid+1;
                break;
            }

            if(arr[mid] > m) {
                rt = mid-1; // lt는 0 그대로
            } else {
                lt = mid+1; // rt는 그대로
            }
        }
        return answer;
    }
}
