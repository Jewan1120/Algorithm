import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    static final int MAX_LEN = 100;
    static int r, c, k;
    static int bR, bC;

    public static void main(String[] args) throws Exception {
        r = read() - 1;
        c = read() - 1;
        k = read();
        bR = 3;
        bC = 3;
        int[][] board = new int[MAX_LEN][MAX_LEN];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = read();
        int time = 0;
        while (time <= 100) {
            if (board[r][c] == k) {
                System.out.println(time);
                return;
            }
            if (bR >= bC)
                board = sortR(board);
            else
                board = sortC(board);
            time++;
        }
        System.out.println(-1);
    }

    private static int[][] sortR(int[][] board) {
        HashMap<Integer, Integer> hm;
        bC = 0;
        int[][] nextBoard = new int[MAX_LEN][MAX_LEN];
        for (int i = 0; i < bR; i++) {
            hm = new HashMap<>();
            for (int j = 0; j < bR; j++) {
                if (board[i][j] == 0)
                    continue;
                hm.putIfAbsent(board[i][j], 0);
                hm.replace(board[i][j], hm.get(board[i][j]) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                    (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
            for (int key : hm.keySet())
                pq.offer(new int[] { key, hm.get(key) });
            int idx = 0;
            while (!pq.isEmpty()) {
                if (idx == 50)
                    break;
                int[] set = pq.poll();
                nextBoard[i][idx++] = set[0];
                nextBoard[i][idx++] = set[1];
                bC = Math.max(bC, idx);
            }
        }
        return nextBoard;
    }

    private static int[][] sortC(int[][] board) {
        HashMap<Integer, Integer> hm;
        bR = 0;
        int[][] nextBoard = new int[MAX_LEN][MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++) {
            hm = new HashMap<>();
            for (int j = 0; j < MAX_LEN; j++) {
                if (board[j][i] == 0)
                    continue;
                hm.putIfAbsent(board[j][i], 0);
                hm.replace(board[j][i], hm.get(board[j][i]) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                    (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
            for (int key : hm.keySet())
                pq.offer(new int[] { key, hm.get(key) });
            int idx = 0;
            while (!pq.isEmpty()) {
                if (idx == 50)
                    break;
                int[] set = pq.poll();
                nextBoard[idx++][i] = set[0];
                nextBoard[idx++][i] = set[1];
                bR = Math.max(bR, idx);
            }
        }
        return nextBoard;
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