public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[] arr = new boolean[101];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int p = read();
            if (arr[p]) {
                cnt++;
            }
            arr[p] = true;
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