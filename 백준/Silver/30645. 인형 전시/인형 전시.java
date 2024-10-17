import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int r = read(), c = read();
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[][] board = new int[r + 1][c];
        Arrays.sort(arr);
        Arrays.fill(board[0], Integer.MAX_VALUE);
        int idx = 0;
        for (int i = 0; i < n && idx < r * c; i++) {
            if (arr[n - i - 1] < board[(idx / c)][idx % c]) {
                board[1 + (idx / c)][idx % c] = arr[n - i - 1];
                idx++;
            }
        }
        System.out.println(idx);
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