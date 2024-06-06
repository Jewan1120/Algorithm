import java.util.Arrays;
public class Main {
    
    static char[][] cArr;
    
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        cArr = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(cArr[i], '*');
        recur(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(new String(cArr[i])).append("\n");
        System.out.println(sb);
    }
    
    private static void recur(int y, int x, int n) {
        if (n == 1) return;
        int d = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    remove(y + d, x + d, d);
                else
                    recur(y + i * d, x + j * d, d);
            }
        }
    }
    
    private static void remove(int y, int x, int d) {
        for (int i = y; i < y + d; i++)
            for (int j = x; j < x + d; j++)
                cArr[i][j] = ' ';
    }
}