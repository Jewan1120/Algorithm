import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();
        quardTree(n, 0, 0);
        System.out.println(sb);
    }

    private static void quardTree(int n, int y, int x) {
        if (isPossible(n, y, x)) {
            sb.append(board[y][x]);
        } else {
            sb.append("(");
            quardTree(n / 2, y, x);
            quardTree(n / 2, y, x + n / 2);
            quardTree(n / 2, y + n / 2, x);
            quardTree(n / 2, y + n / 2, x + n / 2);
            sb.append(")");
        }
    }

    private static boolean isPossible(int n, int y, int x) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[y][x] != board[y + i][x + j])
                    return false;
        return true;
    }
}