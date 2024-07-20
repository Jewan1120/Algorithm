import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static char[][] board = new char[5][5];
    static boolean[][] chk = new boolean[5][5];
    static int cnt = 0;
    static int[] result = new int[7];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            board[i] = br.readLine().toCharArray();
        recursive(0, 0);
        System.out.println(cnt);
    }

    private static void recursive(int depth, int p) {
        if (depth == 7) {
            if (bfs())
                cnt++;
            return;
        }
        for (int i = p; i < 25; i++) {
            result[depth] = i;
            recursive(depth + 1, i + 1);
        }
    }

    private static boolean bfs() {
        chk = new boolean[5][5];
        int s = 0;
        for (int i : result) {
            int y = i / 5;
            int x = i % 5;
            if (board[y][x] == 'S')
                s++;
            chk[y][x] = true;
        }
        if (s < 4)
            return false;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (chk[i][j]) {
                    int len = 0;
                    dq.offer(new int[] {i, j});
                    chk[i][j] = false;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        len++;
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (isValid(y, x)) {
                                chk[y][x] = false;
                                dq.offer(new int[] {y, x});
                            }
                        }
                    }
                    if (len == 7)
                        return true;
                    else
                        return false;
                }
        return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < 5 && 0 <= x && x < 5 && chk[y][x];
    }
}