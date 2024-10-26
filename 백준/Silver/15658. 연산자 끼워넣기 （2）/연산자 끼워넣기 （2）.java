public class Main {

    static int n;
    static int[] arr;
    static int[] oper = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        for (int i = 0; i < 4; i++)
            oper[i] = read();
        recursive(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recursive(int depth, int p) {
        if (depth == n) {
            min = Math.min(min, p);
            max = Math.max(max, p);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0)
                continue;
            int next = p;
            switch (i) {
            case 0:
                next += arr[depth];
                break;
            case 1:
                next -= arr[depth];
                break;
            case 2:
                next *= arr[depth];
                break;
            case 3:
                next /= arr[depth];
                break;
            }
            oper[i]--;
            recursive(depth + 1, next);
            oper[i]++;
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