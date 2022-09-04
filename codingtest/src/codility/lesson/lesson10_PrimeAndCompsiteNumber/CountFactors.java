package codility.lesson.lesson10_PrimeAndCompsiteNumber;

// 효율적인 약수 구하기
// 약수 갯수
public class CountFactors {

    public static void main(String[] args) {

    }

    public int solution(int N) {

        int count = 0;
        int sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }

        return count;
    }
}
