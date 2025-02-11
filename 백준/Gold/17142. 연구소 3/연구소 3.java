import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int n, m, minTime = INF;
    static int[][] board;
    static ArrayList<int[]> viruses = new ArrayList<>();
    static ArrayList<int[][]> records = new ArrayList<>();
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int v = read();
                board[i][j] = v;
                if (v == 2)
                    viruses.add(new int[] { i, j });
            }
        used = new boolean[viruses.size()];
        makeMoves();
        recursive(0, 0);
        System.out.println(minTime != INF ? minTime : -1);
    }

    private static void makeMoves() {
        for (int i = 0; i < viruses.size(); i++) {
            int[] s = viruses.get(i);
            boolean[][] visited = new boolean[n][n];
            int[][] record = new int[n][n];
            for (int j = 0; j < n; j++)
                Arrays.fill(record[j], -1);
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(s);
            visited[s[0]][s[1]] = true;
            int time = 0;
            while (!dq.isEmpty()) {
                int size = dq.size();
                while (size-- > 0) {
                    int[] cur = dq.poll();
                    int y = cur[0], x = cur[1];
                    record[y][x] = time;
                    for (int j = 0; j < 4; j++) {
                        int ny = y + dy[j], nx = x + dx[j];
                        if (isValid(ny, nx) && !visited[ny][nx]) {
                            dq.offer(new int[] { ny, nx });
                            visited[ny][nx] = true;
                        }
                    }
                }
                time++;
            }
            records.add(record);
        }
    }

    private static void recursive(int cnt, int depth) {
        if (depth == viruses.size() && cnt != m)
            return;
        if (cnt == m) {
            minTime = Math.min(minTime, calTime());
            return;
        }
        used[depth] = true;
        recursive(cnt + 1, depth + 1);
        used[depth] = false;
        recursive(cnt, depth + 1);
    }

    private static int calTime() {
        int maxTime = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0)
                    continue;
                int time = INF;
                for (int k = 0; k < viruses.size(); k++) {
                    if (!used[k] || records.get(k)[i][j] == -1)
                        continue;
                    time = Math.min(time, records.get(k)[i][j]);
                }
                if (time == INF)
                    return INF;
                maxTime = Math.max(maxTime, time);
            }
        return maxTime;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n && board[y][x] != 1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}