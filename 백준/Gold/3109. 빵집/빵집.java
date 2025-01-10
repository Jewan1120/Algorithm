import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++)
                if (line.charAt(j) == 'x')
                    board[i][j] = true;
        }
        int cnt = 0;
        for (int i = 0; i < r; i++)
            if(dfs(i, 0))
                cnt++;
        System.out.println(cnt);
    }

    private static boolean dfs(int y, int x) {
        if (x == c)
            return true;
        if (!isValid(y, x))
            return false;
        board[y][x] = true;
        if (!dfs(y - 1, x + 1))
            if (!dfs(y, x + 1))
                if (!dfs(y + 1, x + 1))
                    return false;
                else
                    return true;
            else
                return true;
        else
            return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c && !board[y][x];
    }
}