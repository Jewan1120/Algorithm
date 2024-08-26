import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;
    static boolean[] visited;
    static int[] result;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];
        result = new int[n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                int c = line.charAt(j);
                if (c >= 'A') {
                    board[i][j] = -(c - 64);
                } else {
                    board[i][j] = c - 48;
                }
            }
        }
        recursive(0, 1);
        System.out.println(min);
        System.out.println(max);
    }

    private static void recursive(int depth, int p) {
        if (depth == n) {
            if (cycleChk() % 2 == 0) {
                p *= -1;
            }
            min = Math.min(min, p);
            max = Math.max(max, p);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                recursive(depth + 1, p * board[depth][i]);
                visited[i] = false;
            }
        }
    }

    private static int cycleChk() {
        int cnt = 0;
        boolean[] chkArr = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chkArr[i]) {
                cnt++;
                chkArr[i] = true;
            }
            int idx = result[i];
            while (!chkArr[idx]) {
                chkArr[idx] = true;
                idx = result[idx];
            }
        }
        return cnt;
    }
}