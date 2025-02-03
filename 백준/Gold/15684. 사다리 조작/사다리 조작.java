public class Main {

    static int n, m, h, maxDepth;
    static int[] ladders, needs;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        h = read();
        ladders = new int[h];
        needs = new int[n];
        for (int i = 0; i < m; i++) {
            int a = read() - 1, b = read() - 1;
            ladders[a] |= 1 << b;
            needs[b]++;
            needs[b + 1]++;
        }
        if (isValid())
            for (int i = 0; i < 4; i++) {
                maxDepth = i;
                if (recursive(0, 0)) {
                    System.out.println(i);
                    return;
                }
            }
        System.out.println(-1);
    }

    private static boolean recursive(int depth, int p) {
        if (depth == maxDepth)
            return isPossible();
        for (int i = p; i < h * (n - 1); i++) {
            int r = i / (n - 1), c = i % (n - 1);
            if (canPlace(ladders[r], c)) {
                ladders[r] |= 1 << c;
                if (recursive(depth + 1, i + 1))
                    return true;
                ladders[r] &= ~(1 << c);
            }
        }
        return false;
    }

    private static boolean canPlace(int ladder, int p) {
        if ((ladder & (1 << p)) != 0)
            return false;
        if (p > 0 && (ladder & (1 << (p - 1))) != 0)
            return false;
        if (p < n - 1 && (ladder & (1 << (p + 1))) != 0)
            return false;
        return true;
    }

    private static boolean isPossible() {
        for (int i = 0; i < n; i++) {
            int now = i;
            for (int j = 0; j < h; j++) {
                if (now > 0 && (ladders[j] & (1 << (now - 1))) != 0)
                    now--;
                else if (now < n - 1 && (ladders[j] & (1 << now)) != 0)
                    now++;
            }
            if (now != i)
                return false;
        }
        return true;
    }

    private static boolean isValid() {
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (needs[i] % 2 != 0)
                oddCount++;
        }
        return oddCount / 2 < 4;
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