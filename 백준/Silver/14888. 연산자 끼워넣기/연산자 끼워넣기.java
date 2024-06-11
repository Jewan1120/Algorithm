public class Main {
    static int n;
    static int[] num, arr, oper = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        n = read();
        num = new int[n];
        arr = new int[n - 1];
        for (int i = 0; i < n; i++)
            num[i] = read();
        for (int i = 0; i < 4; i++)
            oper[i] = read();
        recur(0);
        System.out.println(max);
        System.out.println(min);
    }
    private static void recur(int depth) {
        if (depth == n - 1) {
            int result = num[0];
            for (int i = 0; i < n - 1; i++) {
                switch (arr[i]) {
                    case 0 :
                        result += num[i + 1];
                        break;
                    case 1 :
                        result -= num[i + 1];
                        break;
                    case 2 :
                        result *= num[i + 1];
                        break;
                    case 3 :
                        result /= num[i + 1];
                        break;
                }
            }
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                arr[depth] = i;
                oper[i]--;
                recur(depth + 1);
                oper[i]++;
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