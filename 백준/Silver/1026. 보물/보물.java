import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = read();
            }
        }
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[0][i] * arr[1][n - i - 1];
        }
        System.out.println(sum);
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