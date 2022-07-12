package inflearn.lecture.section7_bfsdfs_basic;

// 재귀는 스택을 사용한다
public class Problem1_recursive {

    // DFS를 재귀로 한다고 하심 강사님은
    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n - 1);
            System.out.println(n);

        }
    }

    public static void main(String[] args) {
        Problem1_recursive problem1_recursive = new Problem1_recursive();
            problem1_recursive.DFS(3);
    }

}
