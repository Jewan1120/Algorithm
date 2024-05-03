import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int[] p;
        int c;

        public Node(int[] p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] board = new int[h][n][m];
        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int cnt = 0;
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        dq.add(new Node(new int[] {i, j, k}, 0));
                    } else if (board[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        int max = 0;
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            int[] cur = node.p;
            int c = node.c;
            max = Math.max(max, c);
            for (int i = 0; i < 6; i++) {
                int z = cur[0] + dz[i];
                int y = cur[1] + dy[i];
                int x = cur[2] + dx[i];
                if (0 <= z && z < h && 0 <= y && y < n && 0 <= x && x < m) {
                    if (board[z][y][x] == 0) {
                        board[z][y][x] = 1;
                        cnt--;
                        dq.add(new Node(new int[] {z, y, x}, c + 1));
                    }
                }
            }
        }
        if (cnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
        br.close();
    }
}