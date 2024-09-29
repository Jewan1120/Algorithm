import java.util.ArrayList;

// 1
public class Main {

    static final int INF = 400_004;

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> oper = new ArrayList<>();
        int num;
        while ((num = read()) != 0)
            oper.add(num);
        int n = oper.size();
        int[][][] dp = new int[n + 1][5][5];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 5; k++)
                    dp[i][j][k] = INF;
        dp[0][0][0] = 0;
        for (int turn = 1; turn < n + 1; turn++) {
            int to = oper.get(turn - 1);
            for (int l = 0; l < 5; l++)
                for (int r = 0; r < 5; r++) {
                    if (to != r)
                        dp[turn][to][r] = Math.min(dp[turn][to][r], dp[turn - 1][l][r] + cost(l, to));
                    if (to != l)
                        dp[turn][l][to] = Math.min(dp[turn][l][to], dp[turn - 1][l][r] + cost(r, to));
                }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                min = Math.min(min, dp[n][i][j]);
        System.out.println(min);
    }

    private static int cost(int from, int to) {
        if (from == to)
            return 1;
        if (from == 0)
            return 2;
        if (Math.abs(from - to) == 2)
            return 4;
        return 3;
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