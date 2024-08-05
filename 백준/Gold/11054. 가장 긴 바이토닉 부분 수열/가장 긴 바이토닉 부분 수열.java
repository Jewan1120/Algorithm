public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] upDP = new int[n];
        int[] dwDP = new int[n];
        for (int i = 0; i < n; i++) {
            upDP[i] = 1;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    upDP[i] = Math.max(upDP[i], upDP[j] + 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            dwDP[i] = 1;
            for (int j = n - 1; j > i; j--)
                if (arr[i] > arr[j])
                    dwDP[i] = Math.max(dwDP[i], dwDP[j] + 1);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, upDP[i] + dwDP[i]);
        }
        System.out.println(max - 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}