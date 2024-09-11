import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), h = read();
        int[] toUp = new int[n / 2];
        int[] toDw = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            toUp[i] = read();
            toDw[i] = read();
        }
        Arrays.sort(toUp);
        Arrays.sort(toDw);
        int min = n, cnt = 0;
        int l = 0, r = 0;
        for (int i = 1; i <= h; i++) {
            while (l < n / 2 && toUp[l] < i)
                l++;
            while (r < n / 2 && toDw[(n / 2) - r - 1] > h - i)
                r++;
            int broken = (n / 2 - l) + r;
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
        return n;
    }
}