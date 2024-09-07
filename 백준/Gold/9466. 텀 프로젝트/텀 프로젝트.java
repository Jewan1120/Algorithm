public class Main {

    static int cnt;
    static int[] arr;
    static boolean[] visited;
    static boolean[] cycle;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            cnt = 0;
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            cycle = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++)
                arr[i] = read();
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = arr[node];
        if (!visited[next]) {
            dfs(next);
        } else if (!cycle[next]) {
            cnt++;
            while (next != node) {
                cnt++;
                next = arr[next];
            }
        }
        cycle[node] = true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}