import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, n, minDiff;
    static int[][] board;
    static int totalSum;
    static int[] rowSum, colSum;
    static int[] groupA;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            N = Integer.parseInt(br.readLine());
            n = N >> 1;
            board = new int[N][N];
            rowSum = new int[N];
            colSum = new int[N];
            groupA = new int[n];
            totalSum = 0;
            minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    totalSum += board[i][j];
                    rowSum[i] += board[i][j];
                    colSum[j] += board[i][j];
                }
            }
            recursive(1, 1, totalSum - rowSum[0] - colSum[0]);
            sb.append("#").append(tc).append(" ").append(minDiff).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int cnt, int sum) {
        if (cnt > n)
            return;
        if (cnt == n) {
            minDiff = Math.min(minDiff, Math.abs(sum));
            return;
        }
        if (depth == N)
            return;
        recursive(depth + 1, cnt, sum);
        groupA[cnt] = depth;
        recursive(depth + 1, cnt + 1, sum - rowSum[depth] - colSum[depth]);
    }
}