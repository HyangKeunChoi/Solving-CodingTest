package codility.lesson.lesson3_timecComplexity;

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int[] a = {3, 1, 2, 4, 3};
        System.out.println(tapeEquilibrium.solution(a));
    }

    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;

        for (int a : A) {
            right += a;
        }

        // 맨 마지막 원소는 두 배열로 나누었을때 남겨야 하므로 length -1
        for (int i = 0; i < A.length - 1; i++) {
            right -= A[i];
            left += A[i];
            min = Math.min(min, Math.abs(left - right));
        }
        return min;
    }
}
