public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                A[i][j] = read();
        m = read();
        int k = read();
        int[][] B = new int[m][k];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < k; j++)
                B[i][j] = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int v = 0;
                for (int l = 0; l < m; l++)
                    v += A[i][l] * B[l][j];
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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