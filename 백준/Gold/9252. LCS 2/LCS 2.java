import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 1; j++)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        int len = dp[n][m];
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        int y = n, x = m;
        char[] arr = new char[len];
        while (len > 0) {
            if (A[y - 1] == B[x - 1]) {
                arr[--len] = A[y - 1];
                y--;
                x--;
            } else if (dp[y - 1][x] > dp[y][x - 1]) {
                y--;
            } else {
                x--;
            }
        }
        sb.append(arr);
        System.out.println(sb);
    }
}