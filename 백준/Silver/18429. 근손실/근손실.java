public class Main {

    static int n, cnt = 0;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        n = read();
        int k = read();
        arr = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++)
            arr[i] = read() - k;
        recursive(0, 500);
        System.out.println(cnt);
    }

    private static void recursive(int depth, int str) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                int newStr = str + arr[i];
                if (newStr >= 500)
                    recursive(depth + 1, newStr);
                used[i] = false;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}