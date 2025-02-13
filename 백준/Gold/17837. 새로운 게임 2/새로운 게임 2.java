import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    static int n, k;
    static int[][] board;
    static int[][] locations;
    static int[] dy = { 0, 0, 0, -1, 1 }, dx = { 0, 1, -1, 0, 0 };
    static ArrayList<ArrayList<Deque<Integer>>> dqs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        board = new int[n + 1][n + 1];
        locations = new int[k + 1][3];
        for (int i = 0; i < n + 1; i++) {
            dqs.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++)
                dqs.get(i).add(new ArrayDeque<>());
        }
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < n + 1; j++)
                board[i][j] = read();
        for (int i = 1; i < k + 1; i++) {
            int y = read(), x = read(), dir = read();
            locations[i] = new int[] { y, x, dir };
            dqs.get(y).get(x).offerLast(i);
        }
        int time = 0;
        while (time++ < 1000) {
            for (int i = 1; i < k + 1; i++) {
                int[] cur = locations[i];
                int y = cur[0], x = cur[1], dir = cur[2];
                int ny = y + dy[dir], nx = x + dx[dir];
                if (!isValid(ny, nx) || board[ny][nx] == 2) {
                    rotate(i);
                    ny = y - dy[dir];
                    nx = x - dx[dir];
                    if (!isValid(ny, nx) || board[ny][nx] == 2)
                        continue;
                }
                move(i, y, x, ny, nx);
                if (dqs.get(ny).get(nx).size() >= 4) {
                    System.out.println(time);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static void rotate(int idx) {
        int dir = locations[idx][2];
        if (dir == 1 || dir == 3)
            locations[idx][2]++;
        else
            locations[idx][2]--;
    }

    private static void move(int idx, int y, int x, int ny, int nx) {
        Deque<Integer> dq = dqs.get(y).get(x);
        Deque<Integer> temp = new ArrayDeque<>();
        while (!dq.isEmpty() && dq.peekLast() != idx)
            temp.offerFirst(dq.pollLast());
        if (!dq.isEmpty())
            temp.offerFirst(dq.pollLast());
        Deque<Integer> nDq = dqs.get(ny).get(nx);
        while (!temp.isEmpty()) {
            int next = board[ny][nx] == 0 ? temp.pollFirst() : temp.pollLast();
            locations[next][0] = ny;
            locations[next][1] = nx;
            nDq.offerLast(next);
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 < y && y <= n && 0 < x && x <= n;
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