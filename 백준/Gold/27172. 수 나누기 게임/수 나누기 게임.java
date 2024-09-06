public class Main {

    static final int SIZE = 1_000_001;

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int[] score = new int[SIZE];
        boolean[] used = new boolean[SIZE];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);
            used[arr[i]] = true;
        }
        for (int i : arr)
            for (int j = i * 2; j <= max; j += i)
                if (used[j]) {
                    score[i]++;
                    score[j]--;
                }
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(score[i]).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
