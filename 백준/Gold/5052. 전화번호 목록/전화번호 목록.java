import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        Node[] c;
        boolean isEnd;

        Node() {
            c = new Node[10];
            isEnd = false;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        boolean insert(String num) {
            Node cur = root;
            int idx = 0;
            for (int i = 0; i < num.length(); i++) {
                idx = num.charAt(i) - '0';
                if (cur.c[idx] == null)
                    cur.c[idx] = new Node();
                cur = cur.c[idx];
                if (cur.isEnd)
                    return false;
            }
            if (cur.c[idx] != null)
                return false;
            cur.isEnd = true;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, t = Integer.parseInt(br.readLine());
        boolean isPossible;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            Trie trie = new Trie();
            isPossible = true;
            n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                if (!trie.insert(br.readLine()))
                    isPossible = false;
            }
            sb.append(isPossible ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }
}