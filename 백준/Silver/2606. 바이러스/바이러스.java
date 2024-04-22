import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (; m > 0; m--) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(1);
        visited[1] = true;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int i : graph.get(cur)) {
                if (!visited[i]) {
                    cnt++;
                    dq.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}