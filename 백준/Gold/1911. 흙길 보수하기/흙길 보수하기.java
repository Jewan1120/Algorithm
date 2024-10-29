import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), l = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int total = 0, prev = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] < prev)
                continue;
            prev = Math.max(prev, arr[i][0]);
            double len = arr[i][1] - prev;
            int cnt = (int) Math.ceil(len / l);
            total += cnt;
            prev += cnt * l;
        }
        System.out.println(total);
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