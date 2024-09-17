import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = read();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                int typeA = isType(board[0][j], board[0][j + i]);
                for (int k = 1; k < n; k++) {
                    int typeB = isType(board[k][j], board[k][j + i]);
                    if (typeA != typeB) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++)
            Arrays.sort(board[i]);
        Arrays.sort(board, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n - 1; i++)
            if (board[i][m - 1] > board[i + 1][0]) {
                System.out.println(0);
                return;
            }
        System.out.println(1);
    }

    private static int isType(int a, int b) {
        if (a < b)
            return 1;
        else if (a > b)
            return -1;
        return 0;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}