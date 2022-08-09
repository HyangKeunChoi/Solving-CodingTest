package codility.lesson.lesson4_CountingElements;

public class FrogRiverOne {

    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(frogRiverOne.solution(5, A));
    }

    public int solution(int X, int[] A) {
        visited = new boolean[X + 1];
        visited[0] = true;

        for (int i = 0; i < A.length; i++) {
            if (visited[A[i]] == false) {
                visited[A[i]] = true;
                count++;
            }
            if (count == X) {
                return i;
            }
        }
        return -1;
    }
}
