public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n];
        int min = 1000;
        for (int i = 0; i < n; i++)
            arr[i] = read();
        // 1 2 5 3 9
        loop: for (int i = 0; i < n; i++) {
            int time = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (arr[i] + (j - i) * k <= 0)
                    continue loop;
                if (arr[j] != arr[i] + (j - i) * k) {
                    time++;
                }
            }
            min = Math.min(min, time);
        }
        System.out.println(min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}