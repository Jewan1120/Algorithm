import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dx = {0, 0, 0, 0, 1, -1};
        next: while (!(str = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(str);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean[][][] board = new boolean[l][r][c];
            int[] e = new int[3];
            Deque<int[]> dq = new ArrayDeque<>();
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    char[] cArr = br.readLine().toCharArray();
                    for (int k = 0; k < c; k++) {
                        char p = cArr[k];
                        if (p == 'S') {
                            dq.offer(new int[] {i, j, k ,0});
                        } else if (p == 'E') {
                            e = new int[] {i, j, k};
                            board[i][j][k] = true;
                        } else if (p == '.') {
                            board[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                int cnt = cur[3];
                if (cur[0] == e[0] && cur[1] == e[1] && cur[2] == e[2]) {
                    sb.append("Escaped in ").append(cnt).append(" minute(s).\n");
                    continue next;
                }
                for (int i = 0; i < 6; i++) {
                    int z = cur[0] + dz[i];
                    int y = cur[1] + dy[i];
                    int x = cur[2] + dx[i];
                    if (0 <= z && z < l && 0 <= y && y < r && 0 <= x && x < c) {
                        if (board[z][y][x]) {
                            dq.offer(new int[] {z, y, x, cnt + 1});
                            board[z][y][x] = false;
                        }
                    }
                }
            }
            sb.append("Trapped!\n");
        }
        System.out.println(sb.toString());
    }
}