public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), d = read(), k = read(), c = read();
        int[] dishes = new int[n];
        for (int i = 0; i < n; i++)
            dishes[i] = read();
        int[] used = new int[d + 1];
        int max = 0, cnt = 0;
        for (int i = 0; i < k; i++) {
            if (used[dishes[i]] == 0)
                cnt++;
            used[dishes[i]]++;
        }
        max = used[c] == 0 ? cnt + 1 : cnt;
        for (int i = 1; i < n; i++) {
            used[dishes[i - 1]]--;
            if (used[dishes[i - 1]] == 0)
                cnt--;
            if (used[dishes[(i + k - 1) % n]] == 0)
                cnt++;
            used[dishes[(i + k - 1) % n]]++;
            max = Math.max(max, used[c] == 0 ? cnt + 1 : cnt);
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}