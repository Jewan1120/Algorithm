import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j];
                if (line[j] == 'I') {
                    dq.add(new int[] {i, j});
                }
            }
        }
        int cnt = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (0 <= y && y < n && 0 <= x && x < m) {
                    if (board[y][x] != 'X') {
                        if (board[y][x] == 'P') {
                            cnt++;
                        }
                        board[y][x] = 'X';
                        dq.add(new int[] {y, x});
                    }
                }
            }
        }
        System.out.println(cnt != 0 ? cnt : "TT");
    }
}