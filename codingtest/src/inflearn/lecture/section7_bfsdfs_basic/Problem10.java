package inflearn.lecture.section7_bfsdfs_basic;

import java.util.LinkedList;
import java.util.Queue;

// BFS는 노드가 완전하지 않아도(이진 트리가 아니여도) 상관 없다.
// 9번문제를 BFS로 풀기
public class Problem10 {
    Node3 root;
    public int BFS(Node3 root) {
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {

            int length = queue.size();
            for(int i=0; i<length; i++) {
                Node3 currentNode = queue.poll();
                if(currentNode.lt == null && currentNode.rt == null) {
                    return level;
                }
                if(currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                if(currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem10 tree = new Problem10();
        tree.root = new Node3(1);
        tree.root.lt = new Node3(2);
        tree.root.rt = new Node3(3);
        tree.root.lt.lt = new Node3(4);
        tree.root.lt.rt = new Node3(5);
        System.out.println(tree.BFS(tree.root));
    }

}

class Node3 {
    int data;
    Node3 lt, rt;
    public Node3(int value) {
        data = value;
        lt = null;
        rt = null;
    }
}