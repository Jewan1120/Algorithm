public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int[] fruit = new int[10];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        int l = 0, r = 0, len = 0, cnt = 0;
        while (r < n) {
            if (cnt <= 2) {
                if (fruit[arr[r++]]++ == 0) {
                    cnt++;
                }
                if (cnt <= 2) {
                    len = Math.max(len, r - l);
                }
            } else {
                if (--fruit[arr[l++]] == 0) {
                    cnt--;
                }
            }
        }
        System.out.println(len);
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