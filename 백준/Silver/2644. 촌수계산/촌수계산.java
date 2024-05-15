import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 1];
        for (; t > 0; t--) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {s, 0});
        visited[s] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == e) {
                System.out.println(cur[1]);
                return;
            }
            for(int i : graph.get(cur[0])) {
                if (!visited[i]) {
                    dq.offer(new int[] {i, cur[1] + 1});
                    visited[i] = true;
                }
            }
        }
        System.out.println(-1);
    }
}