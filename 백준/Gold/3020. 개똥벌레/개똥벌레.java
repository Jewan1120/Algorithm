public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), h = read();
        int[] toUp = new int[h + 1];
        int[] toDw = new int[h + 1];
        for (int i = 0; i < n / 2; i++) {
            toUp[read()]++;
            toDw[read()]++;
        }
        for (int i = h - 1; i > 0; i--) {
            toUp[i] += toUp[i + 1];
            toDw[i] += toDw[i + 1];
        }
        int min = n, cnt = 0;
        for (int i = 1; i <= h; i++) {
            int broken = toUp[i] + toDw[h - i + 1];
            if (broken < min) {
                min = broken;
                cnt = 1;
            } else if (broken == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);
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