public class Main {

    static int n, minDiff = Integer.MAX_VALUE;
    static int[][] board;
    static int[] rowSum, colSum;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                board[i][j] = read();
                totalSum += board[i][j];
                rowSum[i] += board[i][j];
                colSum[j] += board[i][j];
            }
        recursive(1, 1, totalSum - rowSum[0] - colSum[0]);
        System.out.println(minDiff);
    }

    private static void recursive(int depth, int cnt, int value) {
        if (cnt > n / 2)
            return;
        if (cnt == n / 2) {
            minDiff = Math.min(minDiff, Math.abs(value));
            return;
        }
        if (depth == n)
            return;
        recursive(depth + 1, cnt, value);
        recursive(depth + 1, cnt + 1, value - rowSum[depth] - colSum[depth]);

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