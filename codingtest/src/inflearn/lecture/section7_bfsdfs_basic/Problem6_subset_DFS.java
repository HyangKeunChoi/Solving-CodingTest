package inflearn.lecture.section7_bfsdfs_basic;

// 부분집합 출력 - 공집합은 빼고
// 잘 이해가 안됨
public class Problem6_subset_DFS {
    static int n;
    static int[] ch;

    public void DFS(int L) {
        if(L==n+1) {
            String tmp = "";
            for(int i=1; i<=n; i++) {
                if(ch[i]==1) { // 체크 되었을때
                    tmp+= (i + " ");
                }
            }
            if(tmp.length()>0) System.out.println(tmp);
        } else {
            ch[L] = 1; // 사용한다 표시
            DFS(L+1);
            ch[L] = 0; // 사용안함 표시
            DFS(L+1);
        }
    }

    public static void main(String[] args) {

        Problem6_subset_DFS T = new Problem6_subset_DFS();
        n=3; // 3의 부분 집합
        ch = new int[n+1];
        T.DFS(1);
    }

}
