public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = read();
            long sum = 0, max = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    sum += max - arr[i];
                }
            }
            sb.append(sum).append("\n");
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