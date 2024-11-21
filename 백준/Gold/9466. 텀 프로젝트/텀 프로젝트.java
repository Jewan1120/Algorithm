public class Main {

    static int n;
    static int cnt;
    static int[] arr;

    static boolean[] visited;
    static boolean[] isCycle;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = read();
            cnt = 0;
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            isCycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++)
                arr[i] = read();
            for (int i = 1; i <= n; i++)
                if (!visited[i])
                    recurse(i);
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void recurse(int cur) {
        visited[cur] = true;
        int next = arr[cur];
        if (!visited[next]) {
            recurse(next);
        } else if (!isCycle[next]) {
            cnt++;
            while (next != cur) {
                cnt++;
                next = arr[next];
            }
        }
        isCycle[cur] = true;
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