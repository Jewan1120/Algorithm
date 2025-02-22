import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {

    static class Node {
        Node[] next;
        boolean isEnd;

        Node() {
            next = new Node[hm.size()];
            isEnd = false;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String[] strArr) {
            Node cur = root;
            for (String str : strArr) {
                int idx = hm.get(str);
                if (cur.next[idx] == null)
                    cur.next[idx] = new Node();
                cur = cur.next[idx];
            }
            cur.isEnd = true;
        }

        String print() {
            print(root, 0);
            return sb.toString();
        }

        void print(Node node, int depth) {
            for (int i = 0; i < hm.size(); i++) {
                if (node.next[i] != null) {
                    for (int j = 0; j < depth; j++)
                        sb.append(" ");
                    sb.append(convert.get(i)).append("\n");
                    print(node.next[i], depth + 1);
                }
            }
        }
    }

    static HashMap<String, Integer> hm = new HashMap<>();
    static TreeSet<String> ts = new TreeSet<>();
    static HashMap<Integer, String> convert = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx = 0;
        String[][] strArr = new String[n][];
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine().split("\\\\");
            for (String str : strArr[i])
                ts.add(str);
        }
        for (String str : ts) {
            if (!hm.containsKey(str)) {
                hm.put(str, idx);
                convert.put(idx++, str);
            }
        }
        Trie trie = new Trie();
        for (int i = 0; i < n; i++)
            trie.insert(strArr[i]);
        System.out.println(trie.print());
    }
}