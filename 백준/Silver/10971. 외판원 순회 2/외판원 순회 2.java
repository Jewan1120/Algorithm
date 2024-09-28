import java.util.Arrays;

public class Main {

    static final int INF = 100_000_001;
    static int n;
    static int[][] distance;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        n = read();
        distance = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int p = read();
                if (p == 0)
                    p = INF;
                distance[i][j] = p;
            }
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int result = tsp(0, 1);
        System.out.println(result);
    }

    private static int tsp(int city, int visited) {
        if (visited == (1 << n) - 1)
            return distance[city][0];
        if (dp[city][visited] != -1)
            return dp[city][visited];
        int result = INF;
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if ((visited & (1 << nextCity)) != 0)
                continue;
            int temp = distance[city][nextCity] + tsp(nextCity, visited | (1 << nextCity));
            result = Math.min(result, temp);
        }
        dp[city][visited] = result;
        return result;
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