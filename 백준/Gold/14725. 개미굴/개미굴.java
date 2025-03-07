import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        TreeMap<String, Node> next = new TreeMap<>();
        String value;

        Node(String value) {
            this.value = value;
        }

        void insert(StringTokenizer st) {
            Node cur = this;
            int m = Integer.parseInt(st.nextToken());
            while (m-- > 0) {
                String str = st.nextToken();
                cur.next.putIfAbsent(str, new Node(str));
                cur = cur.next.get(str);
            }
        }

        void print() {
            print(this, 0);
        }

        void print(Node cur, int depth) {
            for (Node node : cur.next.values()) {
                sb.append("--".repeat(depth)).append(node.value).append("\n");
                print(node, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node("");
        while (n-- > 0)
            root.insert(new StringTokenizer(br.readLine()));
        root.print();
        System.out.println(sb);
    }
}