public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] arr = new int[n + 1];
        for (; m > 0; m--) {
            int i = read();
            int j = read();
            int k = read();
            for (; i <= j; i++) {
                arr[i] = k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
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