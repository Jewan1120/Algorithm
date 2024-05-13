import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        int d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        for (; t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] board = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            Deque<Node> dq = new ArrayDeque<>();
            dq.offer(new Node(sy, sx, 0));
            board[sy][sx] = true;
            while (!dq.isEmpty()) {
                Node node = dq.poll();
                if (node.y == ey && node.x == ex) {
                    sb.append(node.d).append("\n");
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int y = node.y + dy[i];
                    int x = node.x + dx[i];
                    if (0 <= y && y < n && 0 <= x && x < n) {
                        if (!board[y][x]) {
                            dq.offer(new Node(y, x, node.d + 1));
                            board[y][x] = true;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}