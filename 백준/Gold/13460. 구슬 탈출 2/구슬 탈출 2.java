import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };
    static boolean[][] board;
    static int goal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        boolean[][] visited = new boolean[n * m][n * m];
        int sR = 0, sB = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                int idx = i * m + j;
                if (c == '#')
                    board[i][j] = true;
                else if (c == 'R')
                    sR = idx;
                else if (c == 'B')
                    sB = idx;
                else if (c == 'O')
                    goal = idx;
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sR, sB });
        visited[sR][sB] = true;
        visited[goal][goal] = true;
        int time = 0;
        while (time <= 10) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                int R = cur[0], B = cur[1];
                if (B == goal)
                    continue;
                if (R == goal) {
                    System.out.println(time);
                    return;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int[] next = { move(R, dir), move(B, dir) };
                    if (!visited[next[0]][next[1]]) {
                        if (next[0] == next[1]) {
                            next = adjust(cur, next, dir);
                        }
                        dq.offer(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
            time++;
        }
        System.out.println(-1);
    }

    private static int move(int ball, int dir) {
        int p = 0;
        int y = ball / m, x = ball % m;
        while (!board[y + dy[dir] * (p + 1)][x + dx[dir] * (p + 1)]) {
            p++;
            if (goal == (y + dy[dir] * p) * m + (x + dx[dir] * p))
                break;
        }
        return (y + dy[dir] * p) * m + (x + dx[dir] * p);
    }

    private static int[] adjust(int[] prev, int[] next, int dir) {
        int R = prev[0], B = prev[1];
        int yR = R / m, xR = R % m;
        int yB = B / m, xB = B % m;
        int nR = next[0], nB = next[1];
        switch (dir) {
        case 0:
            if (yR < yB)
                nR -= m;
            else
                nB -= m;
            break;
        case 1:
            if (yR > yB)
                nR += m;
            else
                nB += m;
            break;
        case 2:
            if (xR < xB)
                nR -= 1;
            else
                nB -= 1;
            break;
        case 3:
            if (xR > xB)
                nR += 1;
            else
                nB += 1;
            break;
        }
        return new int[] { nR, nB };
    }
}