import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[h][w];
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        for (; t > 0; t--) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for (int y = sy; y < ey; y++) {
                for (int x = sx; x < ex; x++) {
                    board[y][x] = true;
                }
            }
        }
        int cnt = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!board[i][j]) {
                    cnt++;
                    int area = 0;
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offer(new int[] {i, j});
                    board[i][j] = true;
                    while (!dq.isEmpty()) {
                        int[] p = dq.poll();
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int y = p[0] + dy[k];
                            int x = p[1] + dx[k];
                            if (0 <= y && y < h && 0 <= x && x < w) {
                                if (!board[y][x]) {
                                    dq.offer(new int[] {y, x});
                                    board[y][x] = true;
                                }
                            }
                        }
                    }
                    al.add(area);
                }
            }
        }
        al.sort((i1, i2) -> i1 - i2);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int i : al) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}