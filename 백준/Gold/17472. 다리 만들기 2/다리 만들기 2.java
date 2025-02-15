import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {

    static int n, m, islandCnt = 0;
    static int[][] board, edges;
    static int[] dy = { -1, 0, 1, 0 }, dx = { 0, -1, 0, 1 };
    static int[] parent;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = read();
        setNumber();
        makeEdge();
        System.out.println(mst());
    }

    private static void setNumber() {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && board[i][j] != 0) {
                    bfs(i, j, ++islandCnt, visited);
                }
    }

    private static void bfs(int sy, int sx, int num, boolean[][] visited) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1];
            board[y][x] = num;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] != 0) {
                    dq.offer(new int[] { ny, nx });
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void makeEdge() {
        edges = new int[islandCnt + 1][islandCnt + 1];
        for (int i = 0; i < islandCnt + 1; i++)
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        for (int y = 0; y < n; y++)
            for (int x = 0; x < m; x++)
                if (board[y][x] == 0) {
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i], nx = x + dx[i];
                        if (isValid(ny, nx) && board[ny][nx] != 0) {
                            int num = board[ny][nx];
                            int dir = (i + 2) % 4;
                            int len = 1;
                            ny = y;
                            nx = x;
                            while (isValid(ny, nx) && board[ny][nx] == 0) {
                                ny += dy[dir];
                                nx += dx[dir];
                                if (isValid(ny, nx) && len >= 2 && board[ny][nx] != 0 && board[ny][nx] != board[y][x]) {
                                    int nNum = board[ny][nx];
                                    int minLen = Math.min(edges[num][nNum], len);
                                    edges[num][nNum] = minLen;
                                    edges[nNum][num] = minLen;
                                    break;
                                }
                                len++;
                            }
                        }
                    }
                }
    }

    private static int mst() {
        int totalLen = 0, mstCnt = 0;
        boolean[] visited = new boolean[islandCnt + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] { 1, 0 });
        while (!pq.isEmpty()) {
            int[] island = pq.poll();
            int cur = island[0], len = island[1];
            if (visited[cur])
                continue;
            visited[cur] = true;
            totalLen += len;
            mstCnt++;
            if (mstCnt == islandCnt)
                return totalLen;
            for (int next = 1; next < islandCnt + 1; next++) {
                if (!visited[next] && edges[cur][next] != Integer.MAX_VALUE) {
                    pq.offer(new int[] { next, edges[cur][next] });
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
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