package codility.lesson.lesson5_PrefixSums;

// 효율적인 약수의 갯수 구하기 (이 문제랑은 상관 없음)
// https://chwan.tistory.com/entry/Java-%EC%95%BD%EC%88%98%EC%9D%98-%EA%B0%9C%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0


public class CountDiv {

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution1(6, 11, 2));
    }

    // time out O(N)
    public int solution(int A, int B, int K) {

        int count = 0;
        for (int i = A; i <= B; i++) {
            if(i % K == 0) {
                count++;
            }
        }
        return count;
    }

    public int solution1(int A, int B, int K) {
        int cnt = 0;

        cnt = (B / K) - (A / K);
        // 경계 값 잘 찾아함
        // A가 K로 나누어 떨어지고 B도 나누어 떨어지고
        // A만 나누어 떨어지고
        // B만 나누어 떨어지고
        // 둘다 안나누어 떨어지고
        if(A % K == 0 ) cnt++;

        return cnt;
    }
}
