public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);
        }
        int[] prime = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                if (prime[j] == 0)
                    prime[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (num > 1) {
                sb.append(prime[num]).append(" ");
                num /= prime[num];
            }
            sb.append("\n");
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