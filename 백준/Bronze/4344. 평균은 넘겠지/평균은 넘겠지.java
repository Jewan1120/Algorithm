public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            int[] arr = new int[n];
            double sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = read();
                sum += arr[i];
            }
            double abs = sum / n;
            double cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > abs)
                    cnt++;
            }
            sb.append(String.format("%.3f%%\n", (cnt / n) * 100));
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}