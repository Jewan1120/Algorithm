import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class Shark {
        int num, idx, dir;
        int[][] priority;

        Shark(int num, int idx, int dir, int[][] priority) {
            this.num = num;
            this.idx = idx;
            this.dir = dir;
            this.priority = priority;
        }

        int[] getPriority() {
            return priority[dir];
        }
    }

    static int n, m, k;
    static int[] scentBoard, remainBoard, move;
    static boolean[] visited;
    static Deque<Shark> sharks = new ArrayDeque<>();
    static Deque<int[]> scentDeque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        move = new int[] { 0, -n, n, -1, 1 };
        scentBoard = new int[n * n];
        remainBoard = new int[n * n];
        visited = new boolean[n * n];
        init();
        int time = 0;
        while (time <= 1000) {
            int size = sharks.size();
            if (size == 1) {
                System.out.println(time);
                return;
            }
            visited = new boolean[n * n];
            while (size-- > 0) {
                Shark shark = sharks.poll();
                int num = shark.num, idx = shark.idx;
                int nextDir = getNextDir(shark);
                int next = idx + move[nextDir];
                if (visited[next])
                    continue;
                visited[next] = true;
                shark.idx = next;
                shark.dir = nextDir;
                sharks.offer(shark);
                scentDeque.offer(new int[] { next, num });
            }
            removeScent();
            putScent();
            time++;
        }
        System.out.println(-1);
    }

    private static void init() throws Exception {
        int[] tempSharks = new int[m + 1];
        for (int i = 0; i < n * n; i++) {
            int num = read();
            if (num != 0) {
                tempSharks[num] = i;
                scentBoard[i] = num;
                remainBoard[i] = k;
            }
        }
        int[] tempDir = new int[m + 1];
        for (int i = 1; i < m + 1; i++)
            tempDir[i] = read();
        for (int i = 1; i < m + 1; i++) {
            int idx = tempSharks[i], dir = tempDir[i];
            int[][] priority = new int[5][5];
            for (int j = 1; j < 5; j++)
                for (int k = 1; k < 5; k++)
                    priority[j][k] = read();
            Shark shark = new Shark(i, idx, dir, priority);
            sharks.offer(shark);
        }
    }

    private static int getNextDir(Shark shark) {
        int[] priority = shark.getPriority();
        int myScent = 0;
        for (int i = 1; i < 5; i++) {
            int dir = priority[i];
            int next = shark.idx + move[dir];
            if (isValid(shark.idx, next)) {
                if (scentBoard[next] == 0)
                    return dir;
                else if (scentBoard[next] == shark.num && myScent == 0)
                    myScent = dir;
            }
        }
        return myScent;
    }

    private static void removeScent() {
        for (int i = 0; i < n * n; i++)
            if (scentBoard[i] != 0 && --remainBoard[i] == 0)
                scentBoard[i] = 0;
    }

    private static void putScent() {
        while (!scentDeque.isEmpty()) {
            int[] scent = scentDeque.poll();
            int idx = scent[0], num = scent[1];
            scentBoard[idx] = num;
            remainBoard[idx] = k;
        }
    }

    private static boolean isValid(int cur, int next) {
        if (next < 0 || next >= n * n)
            return false;
        int curRow = cur / n;
        int nextRow = next / n;
        if (Math.abs(cur - next) == 1 && curRow != nextRow)
            return false;
        return true;
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