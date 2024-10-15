public class Main {

    static int n, m;
    static int max = 0, cnt = 0;
    static int[][] cost;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = read();
            m = read();
            cost = new int[n + 1][n + 1];
            result = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int V = read();
                int A = read();
                int B = read();
                cost[A][B] += V;
            }
            max = 0;
            cnt = 0;
            visited = new boolean[n];
            result = new int[n];
            dfs(0);
            sb.append(max).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += cost[result[i]][result[j]];
                }
            }
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
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