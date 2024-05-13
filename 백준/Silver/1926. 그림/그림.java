import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0, max = 0;
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    int area = 0;
                    dq.offer(new int[] {i, j});
                    board[i][j] = 0;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (0 <= y && y < h && 0 <= x && x < w){
                                if (board[y][x] == 1) {
                                    dq.offer(new int[] {y, x});
                                    board[y][x] = 0;
                                }
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        System.out.println(cnt + "\n" + max);
        br.close();
    }
}