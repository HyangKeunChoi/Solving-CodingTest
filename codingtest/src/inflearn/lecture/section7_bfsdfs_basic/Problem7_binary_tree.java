package inflearn.lecture.section7_bfsdfs_basic;

import java.util.LinkedList;
import java.util.Queue;

// BFS : Breadth-First Search
// 트리의 레벨별로 탐색하는 방법
public class Problem7_binary_tree {

    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;

        // 비어있지 않을때까지
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(level + " 레벨의 원소는 : ");
            for (int i =0; i<len; i++) {
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if(current.lt != null) {
                    Q.offer(current.lt);
                }
                if(current.rt != null) {
                    Q.offer(current.rt);
                }
            }
            level++;
            System.out.println(); // 줄바꿈
        }

    }
    public static void main(String[] args) {
        Problem7_binary_tree tree = new Problem7_binary_tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }

}

class Node {
    int data;
    Node lt, rt;
    public Node(int value) {
        data = value;
        lt = null;
        rt = null;
    }
}