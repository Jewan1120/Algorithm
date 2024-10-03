public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), k = read();
        int[][] arr = new int[n][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 1; j < m + 1; j++)
                arr[i][j] = arr[i][j - 1] + read();
        for (int i = 1; i < m + 1; i++)
            for (int j = 0; j < n; j++)
                if (arr[j][i] >= k) {
                    System.out.println(j + 1 + " " + i);
                    return;
                }
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