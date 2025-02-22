import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        void print() {
            print(0, this);
        }

        void print(int depth, Node cur) {
            for (String str : cur.next.keySet()) {
                for (int i = 0; i < depth; i++)
                    sb.append(" ");
                sb.append(str).append("\n");
                print(depth + 1, cur.next.get(str));
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node();
        while (n-- > 0)
            root.insert(br.readLine());
        root.print();
        System.out.println(sb);
    }
}