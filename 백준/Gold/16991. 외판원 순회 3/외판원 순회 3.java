import java.util.Arrays;

public class Main {

    static int n;
    static final double INF = 100_000_001;
    static double[][] distance;
    static double[][] dp;

    public static void main(String[] args) throws Exception {
        n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        distance = new double[n][n];
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                double d = calculate(arr[i], arr[j]);
                distance[i][j] = d;
                distance[j][i] = d;
            }
        dp = new double[n][1 << n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(tsp(0, 1));
    }

    private static double tsp(int city, int visited) {
        if (visited == (1 << n) - 1)
            return distance[city][0];
        if (dp[city][visited] != -1)
            return dp[city][visited];
        double result = INF;
        for (int nextCity = 0; nextCity < n; nextCity++) {
            if ((visited & (1 << nextCity)) != 0)
                continue;
            double temp = distance[city][nextCity] + tsp(nextCity, visited | (1 << nextCity));
            result = Math.min(result, temp);
        }
        dp[city][visited] = result;
        return result;
    }

    private static double calculate(int[] A, int[] B) {
        double xA = A[0], yA = A[1];
        double xB = B[0], yB = B[1];
        return Math.sqrt((Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2)));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}