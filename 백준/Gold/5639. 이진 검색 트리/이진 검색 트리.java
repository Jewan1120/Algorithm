import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {

        Node root;

        public BinarySearchTree() {
            this.root = null;
        }

        public void insert(int data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }

        public void traversal(Node root) {
            if (root != null) {
                traversal(root.left);
                traversal(root.right);
                sb.append(root.data).append("\n");
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bt = new BinarySearchTree();
        String str;
        while ((str = br.readLine()) != null) {
            bt.insert(Integer.parseInt(str));
        }
        bt.traversal(bt.root);
        System.out.println(sb);
    }
}