import java.util.ArrayList;

public class Main {

    static int n, m, minDistance = Integer.MAX_VALUE;
    static ArrayList<int[]> pArr = new ArrayList<>();
    static ArrayList<int[]> hArr = new ArrayList<>();
    static int[][] distances;
    static int[] choices;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int p = read();
                if (p == 1)
                    pArr.add(new int[] { i, j });
                else if (p == 2)
                    hArr.add(new int[] { i, j });
            }
        distances = new int[pArr.size()][hArr.size()];
        for (int i = 0; i < pArr.size(); i++)
            for (int j = 0; j < hArr.size(); j++) {
                int py = pArr.get(i)[0], px = pArr.get(i)[1];
                int hy = hArr.get(j)[0], hx = hArr.get(j)[1];
                distances[i][j] = Math.abs(py - hy) + Math.abs(px - hx);
            }
        choices = new int[m];
        recursive(0, 0);
        System.out.println(minDistance);
    }

    private static void recursive(int depth, int p) {
        if (depth == m) {
            int totalDistance = 0;
            for (int i = 0; i < pArr.size(); i++) {
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++)
                    distance = Math.min(distance, distances[i][choices[j]]);
                totalDistance += distance;
            }
            minDistance = Math.min(minDistance, totalDistance);
            return;
        }
        for (int i = p; i < hArr.size(); i++) {
            choices[depth] = i;
            recursive(depth + 1, i + 1);
        }
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