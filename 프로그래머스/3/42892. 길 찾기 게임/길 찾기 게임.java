import java.util.ArrayList;

class Solution {
    
    class Node {
        int v, x, y;
        Node left;
        Node right;

        Node(int v, int x, int y) {
            this.v = v;
            this.x = x;
            this.y = y;
        }
    }
    
    ArrayList<Node> tree = new ArrayList<>();
    int preIdx = 0;
    int postIdx = 0;
    int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        for (int i = 0; i < n; i++)
            tree.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        tree.sort((v1, v2) -> v1.y != v2.y ? v2.y - v1.y : v1.x - v2.x);
        Node root = tree.get(0);
        for (int i = 1; i < n; i++)
            insert(root, tree.get(i));
        answer = new int[2][n];
        traversal(root);
        return answer;
    }
    
    void traversal(Node node) {
        answer[0][preIdx++] = node.v;
        if (node.left != null)
            traversal(node.left);
        if (node.right != null)
            traversal(node.right);
        answer[1][postIdx++] = node.v;
    }
    
    void insert(Node root, Node node) {
        if (root.x > node.x)
            if (root.left == null)
                root.left = node;
            else
                insert(root.left, node);
        else if (root.right == null)
            root.right = node;
        else
            insert(root.right, node);
    }
}