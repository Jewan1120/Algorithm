import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static boolean[][] incompatible;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int a, b;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            incompatible = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;
                incompatible[a][b] = true;
                incompatible[b][a] = true;
            }
            int totalCount = backtrack(0, 0);
            sb.append("#").append(tc).append(" ").append(totalCount).append("\n");
        }
        System.out.println(sb);
    }

    static int backtrack(int idx, int usedBit) {
        if (idx == n)
            return 1;
        int count = backtrack(idx + 1, usedBit);
        for (int i = 0; i <= idx; i++)
            if (((usedBit >> i) & 1) == 1 && incompatible[i][idx])
                return count;
        return count + backtrack(idx + 1, usedBit | (1 << idx));
    }
}