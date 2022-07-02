package programmers.withDayoung.week6;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long total = 0;
        for (int i = 1; i <= count; i++) {
            total += price * i;
        }
        if (total < money) {
            return 0;
        }
        return total - money;
    }
}
