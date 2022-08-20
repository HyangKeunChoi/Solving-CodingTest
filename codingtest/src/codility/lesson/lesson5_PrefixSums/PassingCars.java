package codility.lesson.lesson5_PrefixSums;

public class PassingCars {

    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();

        int[] A = {0, 1, 0, 1, 1};

        int[] B = {0, 1, 0, 1, 0, 1 , 1 , 1};
        // System.out.println(passingCars.solution1(A));
        System.out.println(passingCars.solution1(B));
    }

    // O(N^2)
    public int solution(int[] A) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(A[i] == 0 && A[j] == 1) {
                    count++;
                }
            }
        }

        if(count > 1000000000) {
            return -1;
        }

        return count;
    }

    public int solution1(int[] A) {
        int count = 0;
        int sum = 0;

        for(int i=0 ; i<A.length ; i++) {
            if(A[i] == 0) {
                sum++;
            }
            else {
                count += sum;
            }
            if(count > 1000000000 || count <0) {
                return -1;
            }
        }

        return count;
    }
}
