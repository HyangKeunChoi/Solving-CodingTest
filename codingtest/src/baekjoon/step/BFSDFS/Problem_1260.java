package baekjoon.step.BFSDFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.acmicpc.net/problem/1260
// https://m.blog.naver.com/lm040466/221787478911
// DFS와 BFS
public class Problem_1260 {

    public static int[][] matrix;
    public static int[] checked;
    public static int[] checked2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String vertex = line[0];
        String liner = line[1];
        String searchLine = line[2];

        matrix = new int[Integer.parseInt(vertex) + 1][Integer.parseInt(vertex) + 1];
        checked = new int[Integer.parseInt(vertex) + 1];
        checked2 = new int[Integer.parseInt(vertex) + 1];

        for (int i = 0; i < Integer.parseInt(liner); i++) {
            String[] spliteLine = bf.readLine().split(" ");
            int left = Integer.parseInt(spliteLine[0]);
            int right = Integer.parseInt(spliteLine[1]);
            matrix[left][right] = 1;
            matrix[right][left] = 1;
        }

        DFS(Integer.parseInt(searchLine));
        System.out.println();
        BFS(Integer.parseInt(searchLine));
    }

    private static void BFS(int startNum) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNum); // queue에 넣기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(startNum + " ");

        // newline일떄
        // bw.newLine();

        checked2[startNum] = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll(); // queue에서 빼기
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[current][i] == 1 && checked2[i] == 0) {
                    queue.offer(i);
                    checked2[i] = 1;
                    bw.write(i + " ");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    public static void DFS(int startnum) {

        Stack<Integer> stack = new Stack<>();
        stack.push(startnum);
        System.out.print(startnum + " ");
        checked[startnum] = 1;

        while (!stack.isEmpty()) {
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[startnum][i] == 1 && checked[i] == 0) {
                    DFS(i);
                }
            }
            stack.pop();
        }
    }
}
