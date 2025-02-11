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
            board = (bR >= bC) ? sort(board, true) : sort(board, false);
            time++;
        }
        System.out.println(-1);
    }

    private static int[][] sort(int[][] board, boolean isRow) {
        HashMap<Integer, Integer> hm;
        int[][] nextBoard = new int[MAX_LEN][MAX_LEN];
        int maxLen = 0;
        for (int i = 0; i < (isRow ? bR : bC); i++) {
            hm = new HashMap<>();
            for (int j = 0; j < (isRow ? bC : bR); j++) {
                int value = isRow ? board[i][j] : board[j][i];
                if (value == 0)
                    continue;
                hm.put(value, hm.getOrDefault(value, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                    (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
            for (int key : hm.keySet())
                pq.offer(new int[] { key, hm.get(key) });
            int idx = 0;
            while (!pq.isEmpty() && idx < 50) {
                int[] pair = pq.poll();
                if (isRow) {
                    nextBoard[i][idx++] = pair[0];
                    nextBoard[i][idx++] = pair[1];
                } else {
                    nextBoard[idx++][i] = pair[0];
                    nextBoard[idx++][i] = pair[1];
                }
                maxLen = Math.max(maxLen, idx);
            }
        }
        if (isRow)
            bC = maxLen;
        else
            bR = maxLen;
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