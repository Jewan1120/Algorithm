public class Main {

    static int[] arr;
    static boolean[] visited;
    static boolean[] isCycle;
    static boolean[] tracking;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        int n = read();
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        isCycle = new boolean[n + 1];
        tracking = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = read();
        }
        for (int i = 1; i < n + 1; i++)
            if (!visited[i])
                recursion(i);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int i = 1; i < n + 1; i++)
            if (tracking[i])
                sb.append(i).append("\n");
        System.out.println(sb);
    }

    public static void recursion(int node) {
        visited[node] = true;
        int nextNode = arr[node];
        if (!visited[nextNode]) {
            recursion(nextNode);
        } else if (!isCycle[nextNode]) {
            cnt++;
            tracking[node] = true;
            while (nextNode != node) {
                cnt++;
                tracking[nextNode] = true;
                nextNode = arr[nextNode];
            }
        }
        isCycle[node] = true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}