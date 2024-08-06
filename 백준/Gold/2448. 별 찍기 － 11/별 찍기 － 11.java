import java.util.Arrays;
public class Main {

    static char[][] cArr;

    public static void main(String[] args) throws Exception {
        int n = read();
        cArr = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cArr[i], ' ');
            for (int j = 0; j < i * 2 + 1; j++) {
                cArr[i][n - (i + 1) + j] = '*';
            }
        }
        recursive(0, n - 1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(String.valueOf(cArr[i])).append("\n");
        System.out.println(sb);
    }

    private static void recursive(int y, int x, int p) {
        if (p == 0)
            return;
        int d = p / 2;
        for (int i = 0; i < d; i++)
            for (int j = 0; j < ((d - i) * 2) - 1; j++) {
                cArr[y + d + i][x - d + j + i + 1] = ' ';
            }
        recursive(y, x, d);
        recursive(y + d, x - d, d);
        recursive(y + d, x + d, d);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}