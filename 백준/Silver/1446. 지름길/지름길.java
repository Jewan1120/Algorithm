import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), d = read();
        ArrayList<int[]> shortcuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = read(), e = read(), w = read();
            if (e <= d)
                shortcuts.add(new int[] {s, e, w});
        }
        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i <= d; i++) {
            if (i > 0)
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            for (int[] shortcut : shortcuts) {
                if (shortcut[0] == i && dist[i] + shortcut[2] < dist[shortcut[1]])
                    dist[shortcut[1]] = dist[i] + shortcut[2];
            }
        }
        System.out.println(dist[d]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}