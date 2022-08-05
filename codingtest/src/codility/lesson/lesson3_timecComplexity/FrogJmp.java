package codility.lesson.lesson3_timecComplexity;

public class FrogJmp {

    static int count;

    public static void main(String[] args) {

        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10, 85, 30));
        System.out.println(frogJmp.solution(10, 100, 30));
    }

    public int solution(int X, int Y, int D) {

        int count = (int) Math.ceil((double)( Y - X ) / D);

        return count;
    }

}
