package inflearn.lecture.section7_bfsdfs_basic;

// Tree 말단노드까지의 까장 짧은 경로(DFS)
// DFS는 자식 노드가 1개만 있을때 풀기 어렵다

// 최단거리 구하는거는 BFS로 푸는게 맞다고 하심
// 이유 : https://www.acmicpc.net/board/view/27666
public class Problem9 {

    Node2 root;
    public int DFS(int level, Node2 root) {
        if(root.lt ==null && root.rt == null) {
            return level;
        } else {
            return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
        }
    }

    public static void main(String[] args) {
        Problem9 tree = new Problem9();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        System.out.println(tree.DFS(0, tree.root));

    }

}

class Node2 {
    int data;
    Node2 lt, rt;
    public Node2(int value) {
        data = value;
        lt = null;
        rt = null;
    }
}
