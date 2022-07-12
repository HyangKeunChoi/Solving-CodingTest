package inflearn.lecture.section7_bfsdfs_basic;

// 메모이제이션 : 이전에 계산한 값을 메모리에 저장하여 중복적인 계산을 제거하여 실행 속도를 빠르게 해주는 기법
// 피보나치를 재귀로도 하고
// 피보나치를 배열로도 짤 수 있다. - 성능에 더 좋다
public class Problem4_memoization {

    static int[] fibo;

    public int DFS(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        else return DFS(n-2) + DFS(n-1);
    }

    public int DFS2(int n) {
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = DFS2(n-2) + DFS2(n-1);
    }

    // 이미 구한 값은 또 구하지 않도록 조건 추가
    public int DFS3(int n) {

        // 이미 구해진 값은 또 계산하지 않는다
        if(fibo[n] > 0) return fibo[n];
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = DFS2(n-2) + DFS2(n-1);
    }

    public static void main(String[] args) {
        Problem4_memoization problem4_memomization = new Problem4_memoization();
        int n=6;
        System.out.println(problem4_memomization.DFS(n));

        // 너무 느리다
        /*for(int i=1; i<n; i++) {
            System.out.print(problem4_memomization.DFS(i) + " ");
        }*/

        // 배열로 개선 - 그래도 느리다
        fibo= new int[n+1];
        problem4_memomization.DFS2(n);
        for(int i=1; i<n; i++) {
            System.out.print(fibo[i]);
        }
    }
}
