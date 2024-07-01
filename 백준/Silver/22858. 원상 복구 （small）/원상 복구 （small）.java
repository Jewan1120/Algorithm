public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] s = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            s[i] = read();
        for (int i = 0; i < n; i++)
            d[i] = read();
        for (int i = 0; i < k; i++)
            shuffle(s, d);
        StringBuilder sb = new StringBuilder();
        for (int i : s) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void shuffle(int[] s, int[] d) {
        int[] temp = s.clone();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            s[d[i] - 1] = temp[i];
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}