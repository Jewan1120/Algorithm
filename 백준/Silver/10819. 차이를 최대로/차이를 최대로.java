public class Main {

    static int n;
    static int[] result;
    static int[] nums;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws Exception {
        n = read();
        result = new int[n];
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            nums[i] = read();
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[depth] = nums[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}