import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        String str;
        int n;

        public Node(String str, int n) {
            this.str = str;
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (; t > 0; t--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10000];
            Deque<Node> dq = new ArrayDeque<>();
            dq.add(new Node("", a));
            visited[a] = true;
            while (!dq.isEmpty()) {
                Node node = dq.poll();
                String str = node.str;
                int n = node.n;
                if (n == b) {
                    bw.write(str);
                    bw.newLine();
                    break;
                }
                int d = 2 * n % 10000;
                int s = n != 0 ? n - 1 : 9999;
                int l = (n % 1000) * 10 + n / 1000;
                int r = (n % 10) * 1000 + (n / 10);
                if (!visited[d]) {
                    dq.add(new Node(str + "D", d));
                    visited[d] = true;
                }
                if (!visited[s]) {
                    dq.add(new Node(str + "S", s));
                    visited[s] = true;
                }
                if (!visited[l]) {
                    dq.add(new Node(str + "L", l));
                    visited[l] = true;
                }
                if (!visited[r]) {
                    dq.add(new Node(str + "R", r));
                    visited[r] = true;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}