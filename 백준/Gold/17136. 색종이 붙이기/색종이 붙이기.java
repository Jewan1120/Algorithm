public class Main {

    static int[] arr = new int[5];
    static int min = 26;
    static boolean[][] board = new boolean[10][10];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                board[i][j] = read() == 1;
        recursive(0);
        System.out.println(min == 26 ? -1 : min);
    }

    private static void recursive(int depth) {
        if (depth == 100) {
            int cnt = 0;
            for (int i : arr)
                cnt += i;
            min = Math.min(min, cnt);
            return;
        }
        int y = depth / 10, x = depth % 10;
        if (board[y][x]) {
            boolean flg = false;
            for (int k = 0; k < 5; k++) {
                if (!flg && isPossible(y, x, 5 - k))
                    flg = true;
                if (arr[k] < 5 && flg) {
                    fillBoard(y, x, 5 - k, false);
                    arr[k]++;
                    recursive(depth + 1);
                    fillBoard(y, x, 5 - k, true);
                    arr[k]--;
                }
            }
        } else {
            recursive(depth + 1);
        }
    }

    private static boolean isPossible(int y, int x, int k) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                if (!isValid(y + i, x + j))
                    return false;
        return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < 10 && 0 <= x && x < 10 && board[y][x];
    }

    private static void fillBoard(int y, int x, int k, boolean b) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                board[y + i][x + j] = b;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}