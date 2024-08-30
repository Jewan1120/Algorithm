public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read(), read() };
        int min = 100_001;
        for (int i = 0; i < n; i++) {
            int min1 = 100_001, min2 = 100_001;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int dist = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])
                        + Math.abs(arr[i][2] - arr[j][2]);
                if (min1 > dist) {
                    min2 = min1;
                    min1 = dist;
                } else if (min2 > dist)
                    min2 = dist;
                min = Math.min(min, min1 + min2);
            }
        }
        System.out.println(min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}