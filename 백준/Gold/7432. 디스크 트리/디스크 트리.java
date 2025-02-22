import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    static class Node {
        TreeMap<String, Node> next = new TreeMap<>();

        void insert(String dir) {
            String[] strArr = dir.split("\\\\");
            Node cur = this;
            for (String str : strArr) {
                cur.next.putIfAbsent(str, new Node());
                cur = cur.next.get(str);
            }
        }

        String print(StringBuilder sb) {
            print(0, this, sb);
            return sb.toString();
        }

        void print(int depth, Node cur, StringBuilder sb) {
            for (Map.Entry<String, Node> entry : cur.next.entrySet()) {
                sb.append(" ".repeat(depth)).append(entry.getKey()).append("\n");
                print(depth + 1, entry.getValue(), sb);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node();
        while (n-- > 0)
            root.insert(br.readLine());
        StringBuilder sb = new StringBuilder();
        System.out.println(root.print(sb));
    }
}