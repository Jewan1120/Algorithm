import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {

        int time;
        int cur;

        public Node(int time, int cur) {
            this.time = time;
            this.cur = cur;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[100_001];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, N));
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            int cur = node.cur;
            int time = node.time;
            if (cur < 0 || 100_000 < cur || visited[cur])
                continue;
            visited[cur] = true;
            if (cur == K) {
                System.out.println(time);
                break;
            }
            time++;
            dq.add(new Node(time, cur - 1));
            dq.add(new Node(time, cur + 1));
            dq.add(new Node(time, cur * 2));
        }
    }
}
