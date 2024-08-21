public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int cnt = 0;
        int[] chk = { 2, 0, 2, 3 };
        for (int i = 1; i <= n; i++) {
            int num = i;
            int idx = 3;
            while (num > 0) {
                if (num % 10 == chk[idx])
                    idx--;
                num /= 10;
                if (idx < 0) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}