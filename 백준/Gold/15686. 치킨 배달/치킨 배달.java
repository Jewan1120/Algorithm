import java.util.ArrayList;

public class Main {

    static int n, m, min = Integer.MAX_VALUE;
    static ArrayList<int[]> homes = new ArrayList<>(), chickens = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        result = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int p = read();
                if (p == 1) {
                    homes.add(new int[] {i, j});
                } else if (p == 2)
                    chickens.add(new int[] {i, j});
            }
        findChickenLoad(0, 0);
        System.out.println(min);
    }

    private static void findChickenLoad(int depth, int p) {
        if (depth == m) {
            int chickenLoad = 0;
            for (int i = 0; i < homes.size(); i++) {
                int len = Integer.MAX_VALUE;
                int[] h = homes.get(i);
                for (int j = 0; j < m; j++) {
                    int[] c = chickens.get(result[j]);
                    len = Math.min(len, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
                }
                chickenLoad += len;
            }
            min = Math.min(min, chickenLoad);
            return;
        }
        for (int i = p; i < chickens.size(); i++) {
            result[depth] = i;
            findChickenLoad(depth + 1, i + 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}