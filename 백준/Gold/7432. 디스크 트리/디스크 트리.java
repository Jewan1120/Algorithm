import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    static class Node {
        TreeMap<String, Node> next = new TreeMap<>();
        String value;

        Node(String value) {
            this.value = value;
        }

        void insert(String dir) {
            String[] strArr = dir.split("\\\\");
            Node cur = this;
            for (String str : strArr) {
                cur.next.putIfAbsent(str, new Node(str));
                cur = cur.next.get(str);
            }
        }

        String print(StringBuilder sb) {
            print(0, this, sb);
            return sb.toString();
        }

        void print(int depth, Node cur, StringBuilder sb) {
            for (Node node : cur.next.values()) {
                sb.append(" ".repeat(depth)).append(node.value).append("\n");
                print(depth + 1, node, sb);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node("");
        while (n-- > 0)
            root.insert(br.readLine());
        StringBuilder sb = new StringBuilder();
        System.out.println(root.print(sb));
    }
}