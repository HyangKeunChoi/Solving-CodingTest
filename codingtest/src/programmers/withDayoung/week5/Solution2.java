package programmers.withDayoung.week5;

import java.util.Stack;

/*
 * 2019 카카오 개발자 겨울 인턴십 > 크레인 인형뽑기 게임
 * stack
 * push : 값 추가
 * pop : 가장 위에 원소 제거
 * clear : 전체 제거
 * peek : 가장 위에 값 출력
 *
 *
 * https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%AC%EB%A0%88%EC%9D%B8-%EC%9D%B8%ED%98%95%EB%BD%91%EA%B8%B0-%EA%B2%8C%EC%9E%84-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[][] arr = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] arr2 = {1,5,3,5,1,2,1,4};

        System.out.println(solution2.solution(arr, arr2));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if(stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move -1] = 0; // 꺼냈으니까 0으로 초기화
                    break;
                }
            }
        }
        return answer;
    }
}
