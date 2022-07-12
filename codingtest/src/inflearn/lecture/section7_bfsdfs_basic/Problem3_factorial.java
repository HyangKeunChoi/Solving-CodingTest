package inflearn.lecture.section7_bfsdfs_basic;

public class Problem3_factorial {

    public static void main(String[] args) {
        Problem3_factorial problem3_factorial = new Problem3_factorial();
        System.out.println(problem3_factorial.DFS(5));
    }

    public int DFS(int n) {
        if(n==1) return 1;
        else return n*DFS(n-1);
    }

}
