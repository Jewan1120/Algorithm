import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;
    static int n;
    static boolean[] cols, d1, d2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cols = new boolean[n];
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!cols[i] && !d1[depth - i + n - 1] && !d2[depth + i]) {
                cols[i] = d1[depth - i + n - 1] = d2[depth + i] = true;
                dfs(depth + 1);
                cols[i] = d1[depth - i + n - 1] = d2[depth + i] = false;
            }
        }
    }
}