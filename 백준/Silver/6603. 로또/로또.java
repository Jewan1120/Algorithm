public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] nums;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        while ((n = read()) != 0) {
            arr = new int[6];
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = read();
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int s, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            arr[depth] = nums[i];
            dfs(i + 1, depth + 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return negative ? ~n + 1 : n;
    }
}