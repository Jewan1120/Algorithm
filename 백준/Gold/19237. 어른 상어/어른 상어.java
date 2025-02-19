import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static class Shark {
        int num, y, x, dir;
        int[][] priority;

        Shark(int num, int y, int x, int dir, int[][] priority) {
            this.num = num;
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.priority = priority;
        }

        int[] getPriority() {
            return priority[dir];
        }
    }

    static int n, m, k;
    static int[][][] scentBoard;
    static boolean[][] visited;
    static Deque<Shark> sharks = new ArrayDeque<>();
    static Deque<int[]> scentDeque = new LinkedList<>();

    static int[] dy = { 0, -1, 1, 0, 0 }, dx = { 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        scentBoard = new int[2][n][n];
        visited = new boolean[n][n];
        init();
        int time = 0;
        while (time <= 1000) {
            int size = sharks.size();
            if (size == 1) {
                System.out.println(time);
                return;
            }
            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], false);
            while (size-- > 0) {
                Shark shark = sharks.poll();
                int num = shark.num, y = shark.y, x = shark.x;
                int nextDir = getNextDir(shark);
                int ny = y + dy[nextDir], nx = x + dx[nextDir];
                if (visited[ny][nx])
                    continue;
                visited[ny][nx] = true;
                shark.y = ny;
                shark.x = nx;
                shark.dir = nextDir;
                sharks.offer(shark);
                scentDeque.offer(new int[] { ny, nx, num });
            }
            removeScent();
            putScent();
            time++;
        }
        System.out.println(-1);
    }

    private static void init() throws Exception {
        int[][] tempSharks = new int[m + 1][];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int num = read();
                if (num != 0) {
                    tempSharks[num] = new int[] { i, j };
                    scentBoard[0][i][j] = num;
                    scentBoard[1][i][j] = k;
                }
            }
        int[] tempDir = new int[m + 1];
        for (int i = 1; i < m + 1; i++)
            tempDir[i] = read();
        for (int i = 1; i < m + 1; i++) {
            int y = tempSharks[i][0], x = tempSharks[i][1], dir = tempDir[i];
            int[][] priority = new int[5][5];
            for (int j = 1; j < 5; j++)
                for (int k = 1; k < 5; k++)
                    priority[j][k] = read();
            Shark shark = new Shark(i, y, x, dir, priority);
            sharks.offer(shark);
        }
    }

    private static int getNextDir(Shark shark) {
        int[] priority = shark.getPriority();
        int myScent = 0;
        for (int i = 1; i < 5; i++) {
            int dir = priority[i];
            int ny = shark.y + dy[dir], nx = shark.x + dx[dir];
            if (isValid(ny, nx)) {
                if (scentBoard[0][ny][nx] == 0)
                    return dir;
                else if (scentBoard[0][ny][nx] == shark.num && myScent == 0)
                    myScent = dir;
            }
        }
        return myScent;
    }

    private static void removeScent() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (scentBoard[0][i][j] != 0 && --scentBoard[1][i][j] == 0)
                    scentBoard[0][i][j] = 0;
    }

    private static void putScent() {
        while (!scentDeque.isEmpty()) {
            int[] scent = scentDeque.poll();
            int y = scent[0], x = scent[1], num = scent[2];
            scentBoard[0][y][x] = num;
            scentBoard[1][y][x] = k;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
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