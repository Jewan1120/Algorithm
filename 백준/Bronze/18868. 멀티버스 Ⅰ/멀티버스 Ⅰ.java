public class Main {

    public static void main(String[] args) throws Exception {
        int m = read(), n = read();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = read();
        int cnt = 0;
        for (int i = 0; i < m - 1; i++)
            for (int j = i + 1; j < m; j++)
                if (isPossible(arr[i], arr[j], n)) {
                    cnt++;
                }
        System.out.println(cnt);
    }

    private static boolean isPossible(int[] u1, int[] u2, int n) {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (u1[i] < u1[j] && !(u2[i] < u2[j]))
                    return false;
                if (u1[i] == u1[j] && !(u2[i] == u2[j]))
                    return false;
                if (u1[i] > u1[j] && !(u2[i] > u2[j]))
                    return false;
            }
        return true;
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