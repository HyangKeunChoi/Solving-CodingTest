package inflearn.lecture.section7_bfsdfs_basic;

// 이진트리 순회
// DFS : 깊이 우선 탐색
// 전위 순회 : 부모 -> 왼쪽자식 -> 오른쪽 자식 ( 부모가 먼저)
//  - 1 2 4 5 3 6 7
// 중위 순회 : 왼쪽자식 -> 부모 -> 오른쪽 자식 ( 부모가 가운데)\
// - 4 2 5 1 6 3 7
// 후위 순회 : 왼쪽자식 -> 오른쪽 자식 -> 부모 ( 부모가 나중에)
// - 4 5 2 6 7 3 1

// 전위 순회와 후위순회를 연습해 보세요
public class Problem5_DFS {

    Node root;
    public void DFS(Node root) {
        if(root == null) {
            return; // 말단 노드까지 온 상태
        } else {
            // System.out.printf(root.data + " "); // 전위 순회
            DFS(root.lt);
            // System.out.printf(root.data + " "); // 중위 순회
            DFS(root.rt);
            System.out.printf(root.data + " "); // 후위 순회
        }

    }

    public static void main(String[] args) {
        Problem5_DFS tree = new Problem5_DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }

}

/*
class Node {
    int data;
    Node lt, rt; // 왼쪽자식 노드의 주소, 오른쪽 자식의 주소

    public Node(int value) {
        data = value;
        lt = null;
        rt = null;
    }
}*/
