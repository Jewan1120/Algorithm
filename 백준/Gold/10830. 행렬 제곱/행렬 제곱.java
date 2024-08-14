import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1_000;
    static int n;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] powMatrix = pow(matrix, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(powMatrix[i][j] % MOD).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] pow(int[][] m, long b) {
        if (b == 1) {
            return m;
        }
        int[][] powMatrix = pow(m, b / 2);
        powMatrix = multiply(powMatrix, powMatrix);
        if (b % 2 == 1) {
            powMatrix = multiply(powMatrix, matrix);
        }
        return powMatrix;
    }

    private static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) {
                    result[i][j] += (m1[i][k] * m2[k][j]) % MOD;
                }
        return result;
    }
}