public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = arr[i] * arr[j];
                if (chk(k)) {
                    max = Math.max(max, k);
                }
            }
        }
        System.out.println(max);
    }

    private static boolean chk(int k) {
        int temp = k;
        int c = temp % 10 + 1;
        while (temp > 0) {
            if (temp % 10 == c - 1) {
                c = temp % 10;
                temp /= 10;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}