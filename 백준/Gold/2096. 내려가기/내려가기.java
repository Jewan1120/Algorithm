import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int p = Integer.parseInt(st.nextToken());
            maxDp[0][i] = p;
            minDp[0][i] = p;
        }
        int[] d = {-1, 0, 1};
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
            for (int j = 0; j < 3; j++) {
                int p = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    if (0 <= j + d[k] && j + d[k] < 3) {
                        maxDp[i][j] = Math.max(maxDp[i][j], p + maxDp[i - 1][j + d[k]]);
                        minDp[i][j] = Math.min(minDp[i][j], p + minDp[i - 1][j + d[k]]);
                    }
                }
            }
        }
        int max = Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2]));
        int min = Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2]));
        System.out.printf("%d %d", max, min);
        br.close();
    }
}