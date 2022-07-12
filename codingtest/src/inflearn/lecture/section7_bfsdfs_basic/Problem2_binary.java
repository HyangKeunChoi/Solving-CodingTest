package inflearn.lecture.section7_bfsdfs_basic;

// 2진수 구하기
public class Problem2_binary {

    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        Problem2_binary problem2_binary = new Problem2_binary();
        problem2_binary.DFS(11);
    }
}
